package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Screen {
    private long id;
    private double salePrice;
    private Date makeDate;
    private String manufacturer;
    private String model;

    public Screen(long id, double salePrice, Date makeDate, String manufacturer, String model) {
        this.id = id;
        this.salePrice = salePrice;
        this.makeDate = makeDate;
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public abstract String getType();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public Date getMakeDate() {
        return makeDate;
    }

    public void setMakeDate(Date makeDate) {
        this.makeDate = makeDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public abstract boolean equals(Object o1);

    // returns all the screen data with spaces in between so that printInventory() can later delimit this output by spaces
    public String toString() {
        SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy"); // use SimpleDateFormat to format date properly
        return getType() + " " +
                getId() + " " +
                getSalePrice() + " " +
                date.format(getMakeDate()) + " " +
                getManufacturer() + " " +
                getModel();
    }
}
