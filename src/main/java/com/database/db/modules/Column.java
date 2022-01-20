package com.database.db.modules;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Type;

@Data
@AllArgsConstructor
public class Column {
    private String name;
    private Type type;
    private Boolean isPK;
}
