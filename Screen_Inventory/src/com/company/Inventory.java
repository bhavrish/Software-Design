package com.company;

import java.util.ArrayList;

public class Inventory {
    private final ArrayList<Screen> listInventory;

    public Inventory() {
        listInventory = new ArrayList<Screen>();
    }

    // return inventory size
    public int inventoryCount() {
        return listInventory.size();
    }

    // add to inventory if listInventory does not contain similar screen, otherwise throw exception
    public boolean addToInventory(Screen screen) throws Exception {
        if (listInventory.contains(screen)) {
            throw new Exception("The inventory contains a similar Screen object");
        }
        else {
            listInventory.add(screen);
            return true; // returns true if no duplicate element
        }
    }

    // iterates over listInventory and adds screen to computerMonitorsArrList if screen is an instance of ComputerMonitor
    public ArrayList<ComputerMonitor> listComputerMonitor() {
        ArrayList<ComputerMonitor> computerMonitorsArrList = new ArrayList<ComputerMonitor>();

        for(Screen screen : listInventory) {
            if (screen instanceof ComputerMonitor)
                computerMonitorsArrList.add((ComputerMonitor) screen);
        }

        return computerMonitorsArrList;
    }

    // iterates over listInventory and adds screen to smartTVArrList if screen is an instance of SmartTV
    public ArrayList<SmartTV> listSmartTV() {
        ArrayList<SmartTV> smartTVArrList = new ArrayList<SmartTV>();

        for(Screen screen : listInventory) {
            if (screen instanceof SmartTV)
                smartTVArrList.add((SmartTV) screen);
        }

        return smartTVArrList;
    }

    // prints formatted inventory data
    public void printInventory() {
        String horizontalLine = "+---------+--------------+---------------+-------------+-----------------+------------+---------+--------------+";
        System.out.println(horizontalLine);
        System.out.printf("%s %7s %s %12s %s %13s %s %11s %s %15s %s %10s %s %7s %s %12s %s %n",
                "|", "Type",
                "|", "Id",
                "|", "Price",
                "|", "Make Date",
                "|", "Manufacturer",
                "|", "Model",
                "|", "Glass",
                "|", "OS",
                "|");
        System.out.println(horizontalLine);

        for(Screen screen : listInventory) {
            // make OperatingSystem and glassThickness an empty string so if they don't exist, nothing will be printed
            String operatingSystem = "";
            String glassThickness = "";

            if (screen instanceof SmartTV) { // if screen is of type SmartTV, update operatingSystem
                operatingSystem = ((SmartTV) screen).getOperatingSystem();
            }
            else if (screen instanceof CRT) { // if screen is of type CRT, update glassThickness
                glassThickness = Double.toString(((CRT) screen).getGlassThickness());
            }

            String[] properties = screen.toString().split(" "); // use toString method to get properties and then split this string into an array

            System.out.printf("%s %7s %s %12d %s %13.2f %s %11s %s %15s %s %10s %s %7s %s %12s %s %n",
                    "|", properties[0],
                    "|", Long.parseLong(properties[1]),
                    "|", Float.parseFloat(properties[2]),
                    "|", properties[3],
                    "|", properties[4],
                    "|", properties[5],
                    "|", glassThickness,
                    "|", operatingSystem,
                    "|");

            System.out.println(horizontalLine);
        }
    }
}
