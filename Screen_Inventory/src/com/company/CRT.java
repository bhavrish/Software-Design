package com.company;

import java.util.Date;

public class CRT extends ComputerMonitor {
    private double glassThickness;

    public CRT(double glassThickness, long id, double salePrice, Date makeDate, String manufacturer, String model) {
        super(id, salePrice, makeDate, manufacturer, model);
        this.glassThickness = glassThickness;
    }

    @Override
    public String getType() { // implements getType from the screen abstract class
        return "CRT";
    }

    @Override
    public boolean equals(Object newObj) { // implements equals() from the screen abstract class
        if (newObj instanceof CRT)
            return ((CRT) newObj).getId() == this.getId();
        else
            return false;
    }

    public double getGlassThickness() {
        return glassThickness;
    }

    public void setGlassThickness(double glassThickness) {
        this.glassThickness = glassThickness;
    }
}
