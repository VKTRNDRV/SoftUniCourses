package orm;

import java.sql.SQLException;

public interface DbContext<E> {
    boolean persists(E entity) throws SQLException, IllegalAccessException;
    Iterable<E> find(Class<E> table);
    Iterable<E> find(Class<E> table, String where);
    E findFirst(Class<E> table);
    E findFirst(Class<E> table, String where);

}
