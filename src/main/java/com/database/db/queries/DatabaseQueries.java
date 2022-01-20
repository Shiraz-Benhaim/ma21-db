package com.database.db.queries;

import com.database.db.modules.Table;

public interface DatabaseQueries {
    void insertTable(Table table);
    void deleteTable(String tableName);
    String[] getTablesNames();
    void switchTable(String tableName);
}
