package orm;

import orm.annotations.Column;
import orm.annotations.Entity;
import orm.annotations.Id;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class EntityManager<E> implements DbContext<E> {
    private Connection connection;

    public EntityManager(Connection connection){
        this.connection = connection;
    }

    @Override
    public boolean persist(E entity) throws SQLException, IllegalAccessException {
//        String tableName = this.getTableName(entity);
//        String fieldList = this.getDBFieldsWithoutID(entity);
//        String valueList = this.getValuesWithoutID(entity);
//
//        String sql = String.format("INSERT INTO %s (%s) VALUES (%s)"
//                , tableName, fieldList, valueList);
//
//        return this.connection.prepareStatement(sql).execute();

        Field pkField = getID(entity.getClass());
        pkField.setAccessible(true);
        Object primaryKeyValue = pkField.get(entity);

        if(primaryKeyValue == null || (long) primaryKeyValue <= 0){
            return doInsert(entity);
        }

        return doUpdate(entity);
    }

    @Override
    public Iterable<E> find(Class<E> table) {
        return null;
    }

    @Override
    public Iterable<E> find(Class<E> table, String where)
            throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Statement statement = connection.createStatement();
//        String tableName = getID(table).getAnnotation(Column.class).name();
//        String query = String.format("SELECT * FROM %s WHERE %s LIMIT 1",
//                tableName, where);
//
//        E entity = table.getDeclaredConstructor().newInstance();
//        ResultSet resultSet = statement.executeQuery(query);
//
//        if(resultSet.next()){
//            fillEntity(table, resultSet, entity);
//        }
//
//        return (Iterable<E>) entity;

        return null;
    }

    private void fillEntity(Class<E> table, ResultSet resultSet, E entity) throws SQLException, IllegalAccessException {
        for (Field field : table.getDeclaredFields()) {
            if (field.isAnnotationPresent(Column.class)) {
                fillFieldData(entity, field, resultSet);
            }
        }
    }

    public void fillFieldData(E entity, Field field, ResultSet resultSet) throws SQLException, IllegalAccessException {
        field.setAccessible(true);
        String columnName = field.getAnnotation(Column.class).name();
        Object value = resultSet.getObject(columnName);

        // parse problematic date datatype
        if (field.getType().equals(LocalDate.class) && value instanceof Date) {
            Date sqlDate = (Date) value;
            LocalDate localDate = sqlDate.toLocalDate();
            field.set(entity, localDate);
        } else {
            field.set(entity, value);
        }
    }

    @Override
    public E findFirst(Class<E> table) {
        return null;
    }

    @Override
    public E findFirst(Class<E> table, String where)
            throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Statement statement = connection.createStatement();
        E entity = table.getDeclaredConstructor().newInstance();
        String tableName = getTableName(entity);
        String query = String.format("SELECT * FROM %s WHERE %s LIMIT 1",
                tableName, where);

        ResultSet resultSet = statement.executeQuery(query);

        if(resultSet.next()){
            fillEntity(table, resultSet, entity);
        }

        return entity;
    }

    private String getTableName(E entity) {
        Entity annotation = entity.getClass().getAnnotation(Entity.class);

        if(annotation == null){
            throw new ORMException("Provided class does not have Entity annotation");
        }

         return annotation.name();
    }

    private String getDBFieldsColumnNamesWithoutID(E entity) {
        return Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(f -> f.getAnnotation(Column.class) != null)
                .map(f -> f.getAnnotation(Column.class).name())
                .collect(Collectors.joining(","));
    }

    private String getValuesWithoutID(E entity) throws IllegalAccessException {
        Field[] declaredFields = entity.getClass().getDeclaredFields();
        List<String> result = new ArrayList<>();

        for(Field declaredField : declaredFields){
            if(declaredField.getAnnotation(Column.class) == null){
                continue;
            }

            declaredField.setAccessible(true);
            Object value = declaredField.get(entity);
            result.add("'" + value.toString() + "'");
        }

        return String.join(",", result);
    }

    private Field getID(Class<?> entity){
        return Arrays.stream(entity.getDeclaredFields())
                .filter(x -> x.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Entity has no Primary Key"));
    }

    public boolean doInsert(E entity)
            throws IllegalAccessException, SQLException {
        String tableName = this.getTableName(entity);
        String columnsWithoutID = this.getDBFieldsColumnNamesWithoutID(entity);
        String valuesWithoutID = this.getValuesWithoutID(entity);
        String query = String.format("INSERT INTO %s (%s) VALUES (%s)"
                , tableName, columnsWithoutID, valuesWithoutID);

        return connection.prepareStatement(query).execute();
    }

    public boolean doUpdate(E entity)
            throws IllegalAccessException, SQLException {

        String tableName = this.getTableName(entity);

        Field pkField = this.getID(entity.getClass());
        pkField.setAccessible(true);
        Object pkValue = pkField.get(entity);

        // prepare SET part of query
        String[] columnsWithoutID = this.getDBFieldsColumnNamesWithoutID(entity).split(",");
        String[] fieldValues = this.getValuesWithoutID(entity).split(",");
        StringBuilder setQuery = new StringBuilder();
        for (int i = 0; i < columnsWithoutID.length; i++) {
            if(i == columnsWithoutID.length - 1){
                setQuery.append(String.format("%s = %s", columnsWithoutID[i], fieldValues[i]));
                continue;
            }
            setQuery.append(String.format("%s = %s, ", columnsWithoutID[i], fieldValues[i]));
        }

        String query = String.format("UPDATE %s SET %s WHERE id = %s"
                , tableName, setQuery, pkValue.toString());

        return connection.prepareStatement(query).execute();
    }


}
