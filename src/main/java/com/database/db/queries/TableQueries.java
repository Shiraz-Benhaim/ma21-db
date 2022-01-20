package com.database.db.queries;

import com.database.db.operators.OperatorType;
import com.database.db.modules.Item;
import com.database.db.modules.Table;

public interface TableQueries {
    void insertRecord(Record newRecord);
    void deleteRecord(Item recordId);
    String[] updateRecord(Item recordId, Record updatedRecord);
    Table select(String... columnsNames);
    Table filter(String colName, OperatorType action, Item item); // like "where"
}
