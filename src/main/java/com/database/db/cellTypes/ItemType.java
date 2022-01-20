package com.database.db.cellTypes;

import java.util.Date;

public enum ItemType {
    INT(Integer.class),
    DOUBLE(Double.class),
    STRING(String.class),
    DATE(Date.class);

    private Class type;

    ItemType(Class type) {
        this.type = type;
    }

    public Class getType() {
        return this.type;
    }

    public void setType(Class type) {
        this.type = type;
    }
}
