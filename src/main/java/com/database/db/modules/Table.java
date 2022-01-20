package com.database.db.modules;

import com.database.db.utils.ColumnSearch;
import com.database.db.validation.RecordValidation;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Table {
    private List<Column> columns;
    private List<Record> records;

    public Table(List<Column> columns) {
        this.columns = columns;
        this.records = new ArrayList<>();
    }

    public void addRecord(Record record) {
        RecordValidation recordValidation = new RecordValidation();
        if (recordValidation.isValid(record, this.columns)) {
            this.records.add(record);
        }
    }

    @Override
    public String toString() {
        String data = "";

        // Headers
        for (Column col : this.columns) {
            data += String.format("%10s|", col.getName());
        }

        // Records
        for (Record record : this.records) {
            data += "\n";
            for (String header : this.columns.stream()
                                    .map(Column::getName)
                                    .collect(Collectors.toList())) {
                data += String.format("%10s|", record.getItems().get(header).getValue());
            }
        }

        return data + "\n";
    }
}
