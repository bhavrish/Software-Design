package com.company;

import java.util.Date;

public class SmartTV extends Screen {
    private String operatingSystem;

    public SmartTV(String operatingSystem, long id, double salePrice, Date makeDate, String manufacturer, String model) {
        super(id, salePrice, makeDate, manufacturer, model);
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String getType() { // implements getType() from the screen abstract class
        return "Smart";
    }

    @Override
    public boolean equals(Object newObj) { // implements equals() from the screen abstract class
        if (newObj instanceof SmartTV)
            return ((SmartTV) newObj).getModel().equals(this.getModel());
        else
            return false;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
