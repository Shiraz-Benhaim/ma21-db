package com.database.db.utils;

import com.database.db.modules.Column;

import java.util.List;
import java.util.stream.Collectors;

public class ColumnSearch {
    public Column getColumnByName(List<Column> columnList, String colName) {
        List<Column> colWithHeader = columnList.stream()
                .filter(col -> col.getName() == colName)
                .collect(Collectors.toList());

        return (colWithHeader.size() == 0 ? null : colWithHeader.get(0));
    }
}
