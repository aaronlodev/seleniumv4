package com.hexaware.framework;

public enum DriverType {

    Chrome("Chrome"),
    FireFox("FireFox"),

    SauceLabs("SauceLabs"),
    SauceLabsMobileWeb("SauceLabsMobileWeb");


    private final String type;

    DriverType(final String name) {
        type = name;
    }

    public String getType() {
        return type;
    }

}
