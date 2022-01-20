package com.database.db.queries;

public interface DatabaseManagementQueries {
    void insertDB(String dbName);
    String[] getDatabasesNames();
    void switchDatabase (String dbName);
}
