package com.database;

import com.database.db.cellTypes.ItemType;
import com.database.db.handlers.DataBaseManagementHandler;
import com.database.db.modules.Column;
import com.database.db.modules.Item;
import com.database.db.modules.Record;
import com.database.db.modules.Table;
import com.database.db.operators.OperatorType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        try {
            DataBaseManagementHandler dataBaseManagementHandler = new DataBaseManagementHandler();
            dataBaseManagementHandler.switchDatabase("hr");
            dataBaseManagementHandler.db.switchTable("emp");

            ArrayList<Column> columns = new ArrayList<>();
            columns.add(new Column("id", ItemType.INT, true));
            columns.add(new Column("name", ItemType.STRING, false));
            columns.add(new Column("age", ItemType.INT, false));

            Table t = new Table(columns);
            t.addRecord(new Record(new LinkedHashMap<>() {{
                put("id", new Item(1));
                put("name", new Item("Shiraz"));
                put("age", new Item(18));
            }}));
            t.addRecord(new Record(new LinkedHashMap<>() {{
                put("id", new Item(2));
                put("name", new Item("Lia"));
                put("age", new Item(23));
            }}));
            t.addRecord(new Record(new LinkedHashMap<>() {{
                put("id", new Item(3));
                put("name", new Item("Adi"));
                put("age", new Item(45));
            }}));
            System.out.println(t);

            dataBaseManagementHandler.db.table.setLoadedTable(t);
            System.out.println(dataBaseManagementHandler.db.table.select("name", "age"));
        } catch (IOException e) {
            System.out.println("error");
        }
    }
}
