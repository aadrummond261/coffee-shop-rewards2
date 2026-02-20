package org.codedifferently;

import java.util.Scanner;


public class Customer {
    private String name;
    private String email;
    private int drinksPurchased;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.drinksPurchased = 0;

    }

    public Customer() {
        this("Guest", "N/a");
    }

    public String getName() {return name;}
    public String getEmail() {return email;}
    public int getDrinksPurchased() {return drinksPurchased;}

    public void incrementDrinksPurchased() {drinksPurchased++;}

    public boolean isEligibleForRewards() {return drinksPurchased != 0 && drinksPurchased % 5 == 0;}


    }

