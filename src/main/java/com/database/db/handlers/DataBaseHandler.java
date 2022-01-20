package com.database.db.handlers;

import com.database.db.modules.Table;
import com.database.db.queries.DatabaseQueries;
import lombok.Data;

@Data
public class DataBaseHandler implements DatabaseQueries {
    public static String dbDataPath;
    public static String dbMetadataPath;
    public TableHandler table;

    public DataBaseHandler(String dbDataPath, String dbMetadataPath) {
        this.dbDataPath = dbDataPath;
        this.dbMetadataPath = dbMetadataPath;
        this.table = new TableHandler();
    }

    @Override
    public void insertTable(Table table) {
        // TODO
    }

    @Override
    public void deleteTable(String tableName) {
        // TODO
    }

    @Override
    public String[] getTablesNames() {
        // TODO
        return new String[0];
    }

    @Override
    public void switchTable(String tableName) {
        this.table.setTableName(tableName);
        this.table.setLoadedTable(null);
    }
}
