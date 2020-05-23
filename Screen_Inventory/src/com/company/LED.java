package com.company;

import java.util.Date;

public class LED extends ComputerMonitor{
    public LED(long id, double salePrice, Date makeDate, String manufacturer, String model) {
        super(id, salePrice, makeDate, manufacturer, model);
    }

    @Override
    public String getType() { // implements getType from the screen abstract class
        return "LED";
    }

    @Override
    public boolean equals(Object newObj) { // implements equals() from the screen abstract class
        if (newObj instanceof LED)
            return ((LED) newObj).getSalePrice() == this.getSalePrice();
        else
            return false;
    }
}
