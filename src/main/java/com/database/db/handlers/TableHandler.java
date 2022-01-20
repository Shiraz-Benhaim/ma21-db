package com.database.db.handlers;

import com.database.db.utils.SplitTable;
import com.database.db.modules.Item;
import com.database.db.modules.Table;
import com.database.db.operators.filters.FilterEqual;
import com.database.db.operators.filters.FilterRecords;
import com.database.db.operators.OperatorType;
import com.database.db.queries.TableQueries;
import lombok.*;

import java.util.HashMap;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class TableHandler implements TableQueries {
    private final HashMap<OperatorType, FilterRecords> ACTIONS = new HashMap<>() {{
        put(OperatorType.EQUAL, new FilterEqual());
        put(OperatorType.BIGGER, new FilterEqual());
        put(OperatorType.SMALLER, new FilterEqual());
    }};

    @NonNull
    private String tableName;
    private Table loadedTable;

    @Override
    public void insertRecord(Record newRecord) {
        // TODO
    }

    @Override
    public void deleteRecord(Item recordId) {
        // TODO
    }

    @Override
    public String[] updateRecord(Item recordId, Record updatedRecord) {
        // TODO
        return new String[0];
    }

    @Override
    public Table select(String... columnsNames) {
        if (columnsNames.length == 0) {      // in that case all the columns will be returned
            if (this.loadedTable == null) {
                // TODO: load it and return it
            } else {
                return this.loadedTable;
            }
        } else {
            if (this.loadedTable == null) {
                // TODO: load it and return it
            } else {
                // TODO
            }
        }

        return null;
    }

    @Override
    public Table filter(String colName, OperatorType action, Item item) {
        return this.ACTIONS.get(action).filter(this.select(), colName, item);
    }
}
