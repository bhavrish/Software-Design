package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConvert {

    private final ArrayList<MorseCode> listCodes;

    // constructor for MorseCodeConvert
    public MorseCodeConvert(String fileName) {
        listCodes = new ArrayList<MorseCode>();
        Scanner fileReader = null;

        try {
            fileReader = new Scanner(new File(fileName));

            // execute loop while next line exists
            while (fileReader.hasNext()) {
                String line = fileReader.nextLine();

                // turn each string line into an array
                String[] arr = line.split("\t");

                // execute if new string array has 2 components (length is 2)
                if (arr.length == 2) {
                    // use try catch block to make sure that MorseCode object is valid
                    try {
                        // create MorseCode object where first elem in arr represents character and second elem in arr represents morse equivalent
                        MorseCode temp = new MorseCode(arr[0].charAt(0), arr[1]);
                        listCodes.add(temp);
                    }
                    catch (Exception e) {
                        System.out.println(e.toString());
                    }
                }
                else
                    System.out.println("Invalid line: " + line);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Failed to open file: " + fileName);
        }
        finally {
            // close file if not null
            if (fileReader != null)
                fileReader.close();
        }
    }

    // traverse listCodes and print each character and morse equivalent
    public void printEncodingList() {
        for(MorseCode m : listCodes)
            System.out.println(m.getCharacter() + ": " + m.getEncoding());
    }

    // convert given string to morse
    public void encodeString(String s) {
        try {
            for (int i = 0; i < s.length(); i++) {
                Character c1 = s.charAt(i);

                // if character is lower case, convert it to upper case
                if (s.charAt(i) >= 97 && s.charAt(i) <= 122)
                    c1 = Character.toUpperCase(s.charAt(i));

                int asciiVal = c1;

                // if invalid ascii value, print "?"
                if (asciiVal < 32 || asciiVal > 90)
                    System.out.print("?");
                else {
                    for (MorseCode m : listCodes) {

                        // if char exists in listCodes, execute if block
                        if (m.getCharacter() == c1) {
                            // print morse equivalent
                            System.out.print(m.getEncoding() + " ");
                            break;
                        }
                    }
                }
            }
            System.out.print("\n");
        }
        // handles null strings
        catch (Exception e) {
            System.out.println("Null strings are not accepted");
        }
    }

    // converts whole file to morse
    public void encodeFile(String fileName) {
        Scanner fileReader = null;

        try {
            fileReader = new Scanner(new FileInputStream(fileName));

            while (fileReader.hasNext()) {
                String line = fileReader.nextLine();

                // passes each line to encodeString function to prevent code redundancy
                encodeString(line);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Failed to open file: " + fileName);
        }
        finally {
            if (fileReader != null)
                fileReader.close();
        }
    }
}
