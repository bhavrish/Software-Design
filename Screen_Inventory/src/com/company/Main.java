package com.company;
/**
 * Test file for Assignment #4.
 *
 * DO NOT MODIFY
 */

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    Inventory inventoryList = new Inventory();

    public static void main(String[] args) throws Exception {

        Inventory inventoryList = new Inventory();

        Scanner scanner = new Scanner(new File("./src/com/company/Inventory.dat"));

        // skip file's header
        String line = scanner.nextLine();

        while (scanner.hasNextLine()) {

            boolean result = false;

            line = scanner.nextLine();

            String[] arrLine = line.split(",");

            Screen screen = null;

            try {

                if (arrLine.length == 6)
                    screen = new CRT(Double.parseDouble(arrLine[5]), Long.parseLong(arrLine[0]), Double.parseDouble(arrLine[1]), formatter.parse(arrLine[2]), arrLine[3], arrLine[4]);
                else if (arrLine.length == 7)
                    screen = new SmartTV(arrLine[6], Long.parseLong(arrLine[0]), Double.parseDouble(arrLine[1]), formatter.parse(arrLine[2]), arrLine[3], arrLine[4]);
                else
                    screen = new LED(Long.parseLong(arrLine[0]), Double.parseDouble(arrLine[1]), formatter.parse(arrLine[2]), arrLine[3], arrLine[4]);

                if (screen != null) {

                    result = inventoryList.addToInventory(screen);

                    if (!result)
                        System.err.println(String.format("Failed to add to inventory, skipping: %s", line));
                }
            }
            catch (Exception ex) {

                // Uncomment this line when debugging your code to see the full stack trace
                // ex.printStackTrace();

                System.err.println("Duplicate iventory, skipping: " + line);
            }
        }

        System.out.printf("There are %d Screens in the inventory%n", inventoryList.inventoryCount());

        ArrayList<ComputerMonitor> listComputerMonitor = inventoryList.listComputerMonitor();
        System.out.printf("There are %d Computer Monitors%n", listComputerMonitor.size());

        ArrayList<SmartTV> listSmartTV = inventoryList.listSmartTV();
        System.out.printf("There are %d Smart TVs%n", listSmartTV.size());

        inventoryList.printInventory();

        scanner.close();
    }
}