package com.hexaware.framework;

public enum DriverType {

    Chrome("Chrome"),
    FireFox("FireFox");


    private final String type;

    DriverType(final String name) {
        type = name;
    }

    public String getType() {
        return type;
    }

}
