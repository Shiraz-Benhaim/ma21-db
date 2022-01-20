package com.database;

import com.database.db.handlers.DataBaseManagementHandler;
import com.database.db.modules.Item;
import com.database.db.modules.Record;
import com.database.db.modules.Table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        try {
            DataBaseManagementHandler dataBaseManagementHandler = new DataBaseManagementHandler();
            dataBaseManagementHandler.switchDatabase("hr");
            dataBaseManagementHandler.db.switchTable("emp");

            ArrayList<Record> recordList = new ArrayList<>();
            recordList.add(new Record(new HashMap<>() {{
                put("id", new Item(1));
                put("name", new Item("Shiraz"));
                put("age", new Item(18));
            }}));
            recordList.add(new Record(new HashMap<>() {{
                put("id", new Item(2));
                put("name", new Item("Liat"));
                put("age", new Item(34));
            }}));
            recordList.add(new Record(new HashMap<>() {{
                put("id", new Item(3));
                put("name", new Item("Michal"));
                put("age", new Item(13));
            }}));
            Table t = new Table(recordList);
            System.out.println(t.toString());

            dataBaseManagementHandler.db.table.setLoadedTable(t);
            System.out.println((dataBaseManagementHandler.db.table.select("name", "age")).toString());
        } catch (IOException e) {
            System.out.println("error");
        }
    }
}
