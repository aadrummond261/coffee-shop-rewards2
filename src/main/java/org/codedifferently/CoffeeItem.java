package org.codedifferently;
import java.util.Scanner;
public class CoffeeItem {
    private String name;
    private double price;

    public CoffeeItem(String name, double price) {
        this.name = name;
        this.price = price;

    }
    public String getName() {
        return name;


    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
}
