package com.company;

public class MorseCode {

    private char c1;
    private String s1;

    // constructor for MorseCode
    public MorseCode(char c1, String s1) throws Exception {
        int asciiForC1 = c1;

        // if invalid character or string, throw exception
        if (asciiForC1 < 32 || asciiForC1 > 90 || s1.length() < 1)
            throw new Exception("The character " + c1 + " is not a supported Morse character");
        else {
            this.c1 = c1;
            this.s1 = s1;
        }
    }

    // getters
    public char getCharacter() {
        return c1;
    }
    public String getEncoding() {
        return s1;
    }

    // setters
    public void setCharacter(char c1) {
        this.c1 = c1;
    }
    public void setEncoding(String s1) {
        this.s1 = s1;
    }
}
