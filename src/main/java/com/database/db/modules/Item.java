package com.database.db.modules;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Type;

@Data
@AllArgsConstructor
public class Item<T extends Type> {
    private T value;
}
