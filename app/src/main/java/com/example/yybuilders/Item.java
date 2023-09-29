package com.example.yybuilders;

public class Item {
    private String name;
    private int number;

    public Item(String name, int number) {
        this.name = name;
        this.number = number;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Setter method for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for number
    public int getNumber() {
        return number;
    }

    // Setter method for number
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return name + " (" + number + ")";
    }
}

