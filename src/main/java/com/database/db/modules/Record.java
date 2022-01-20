package com.database.db.modules;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedHashMap;

@Data
@AllArgsConstructor
public class Record {
    private LinkedHashMap<String, Item> items;

    public Record() {
        this.items = new LinkedHashMap<>();
    }

    public void addItem(String colName, Item item) {
        this.items.put(colName, item);
    }

    public Item getItem(String colName) {
        return this.items.get(colName);
    }
}
