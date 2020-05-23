package com.company;

import java.util.Date;

// abstract class so don't need to implement abstract methods from the screen abstract class
public abstract class ComputerMonitor extends Screen {
    public ComputerMonitor(long id, double salePrice, Date makeDate, String manufacturer, String model) {
        super(id, salePrice, makeDate, manufacturer, model);
    }
}
