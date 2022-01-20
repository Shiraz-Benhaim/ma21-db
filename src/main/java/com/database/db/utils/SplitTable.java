package com.database.db.utils;

import com.database.db.modules.Column;
import com.database.db.modules.Record;
import com.database.db.modules.Table;

public class SplitTable {
    /*
    * Function get a specific columns from the table.
    * table - the whole table
    * columnsNames - the names of the relevant columns
    * */
    public Table split(Table table, String... columnsNames) {
        Table subTable = new Table();

        if (columnsNames.length == 0) {      // in that case all the columns will be returned
            return subTable;
        }
        else {
            for (Record record : table.getRecords()) {
                Record currRecord = new Record();
                for (String colName : columnsNames) {
                    currRecord.addItem(colName, record.getItem(colName));
                }
                subTable.addRecord(currRecord);
            }
        }

        return subTable;
    }
}
