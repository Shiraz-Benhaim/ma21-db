package com.database.db.utils;

import com.database.db.modules.Column;
import com.database.db.modules.Record;
import com.database.db.modules.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class SplitTable {
    private Table table;

    /*
    * Function get a specific columns from the table.
    * table - the whole table
    * columnsNames - the names of the relevant columns
    * */
    public Table split(String... columnsNames) {
        Table subTable = new Table(this.getColumns(columnsNames));

        if (columnsNames.length == 0) {      // in that case all the columns will be returned
            return subTable;
        }
        else {
            for (Record record : this.table.getRecords()) {
                Record currRecord = new Record();
                for (String colName : columnsNames) {
                    currRecord.addItem(colName, record.getItem(colName));
                }
                subTable.addRecord(currRecord);
            }
        }

        return subTable;
    }

    /*
    * Function returns the columns that has the name from the specified names
    * columnsNames - the specified names of columns
    * returns a list of relevant columns
    * */
    public List<Column> getColumns(String... columnsNames) {
        ColumnSearch columnSearch = new ColumnSearch();
        List<Column> columns = new ArrayList<>();

        for (String colName : columnsNames) {
            Column colWithHeader = columnSearch.getColumnByName(this.table.getColumns(), colName);
            if (colWithHeader != null) {
                columns.add(colWithHeader);
            }
        }

        return columns;
    }
}
