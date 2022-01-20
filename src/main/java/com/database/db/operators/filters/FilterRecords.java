package com.database.db.operators.filters;

import com.database.db.modules.Item;
import com.database.db.modules.Table;

public interface FilterRecords {
    public Table filter(Table table, String colName, Item item);
}
