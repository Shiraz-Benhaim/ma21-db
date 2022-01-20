package com.database.db.operators.filters;

import com.database.db.modules.Item;
import com.database.db.modules.Table;

public class FilterBigger implements FilterRecords {
    @Override
    public Table filter(Table table, String colName, Item item) {
        // Where item in some column > item
        return null;
    }
}
