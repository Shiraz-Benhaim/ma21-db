package com.database.db.validation;

import com.database.db.modules.Column;
import com.database.db.modules.Record;
import com.database.db.utils.ColumnSearch;

import java.util.List;

public class RecordValidation {
    public boolean isValid(Record record, List<Column> columns) {
        ColumnSearch columnSearch = new ColumnSearch();

        if (record.getItems().size() != columns.size()) {
            return false;
        }

        for (String header : record.getItems().keySet()) {
            Column colWithHeader = columnSearch.getColumnByName(columns, header);
            if (colWithHeader != null) {
                if (!colWithHeader.getType().getType()
                        .equals(record.getItems().get(header).getValue().getClass())) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
