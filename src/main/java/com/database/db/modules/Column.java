package com.database.db.modules;

import com.database.db.cellTypes.ItemType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Column {
    private String name;
    private ItemType type;
    private Boolean isPK;
}
