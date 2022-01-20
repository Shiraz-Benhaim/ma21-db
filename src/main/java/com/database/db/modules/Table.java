package com.database.db.modules;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Table {
    private List<Record> records;

    public Table() {
        this.records = new ArrayList<>();
    }

    public void addRecord(Record record) {
        this.records.add(record);
    }

    @Override
    public String toString() {
        String data = "";
        ArrayList<String> headers = new ArrayList<>();

        for (String header : this.records.get(0).getItems().keySet()) {
            data += String.format("|%10s|", header);
            headers.add(header);
        }

        for (Record record : this.records) {
            data += "\n";
            for (String header : headers) {
                data += String.format("|%10s|", record.getItems().get(header).getValue());
            }
        }

        return data + "\n";
    }
}
