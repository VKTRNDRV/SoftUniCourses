package bakery.repositories.interfaces;

import bakery.common.ExceptionMessages;
import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class TableRepositoryImpl implements TableRepository<Table> {

    private Collection<Table> models;

    public TableRepositoryImpl(){
        this.models = new ArrayList<>();
    }

    @Override
    public Table getByNumber(int number) {
        for(Table table : models){
            if(table.getTableNumber() == number){
                return table;
            }
        }
        return null;
    }

    @Override
    public Collection<Table> getAll() {
        return Collections
                .unmodifiableCollection(models);
    }

    @Override
    public void add(Table table) {
        if(containsTable(table)){
            throw new IllegalArgumentException(
                    String.format(
                    ExceptionMessages.TABLE_EXIST,
                    table.getTableNumber()));
        }
        models.add(table);
    }

    private boolean containsTable(Table table) {
        int tableNumber = table.getTableNumber();
        for(Table t : models){
            if(t.getTableNumber() == tableNumber){
                return true;
            }
        }
        return false;
    }
}
