package com.database.db.modules;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class Record {
    private Map<String ,Item> items;

    public Record() {
        this.items = new HashMap<>();
    }

    public void addItem(String colName, Item item) {
        this.items.put(colName, item);
    }

    public Item getItem(String colName) {
        return this.items.get(colName);
    }
}
