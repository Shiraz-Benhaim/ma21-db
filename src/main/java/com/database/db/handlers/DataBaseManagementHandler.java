package com.database.db.handlers;

import com.database.db.queries.DatabaseManagementQueries;
import lombok.Data;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@Data
public class DataBaseManagementHandler implements DatabaseManagementQueries {
    public DataBaseHandler db;
    private String path;

    public DataBaseManagementHandler() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src\\main\\resources\\db.properties"));
        this.path = properties.getProperty("DatabaseManagementFolder");
    }

    @Override
    public void insertDB(String dbName) {

    }

    @Override
    public String[] getDatabasesNames() {
        return new String[0];
    }

    @Override
    public void switchDatabase(String dbName) {
        this.db = new DataBaseHandler(this.path + "\\" + dbName + ".json",
                this.path + "\\" + dbName + "_metadata.csv");
    }
}
