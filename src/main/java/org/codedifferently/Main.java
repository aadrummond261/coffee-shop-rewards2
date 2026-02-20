package org.codedifferently;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        CoffeeItem latte = new CoffeeItem("Latte", 4.50);
        CoffeeItem cappuccino = new CoffeeItem("Cappuccino", 5.00);
        CoffeeItem espresso = new CoffeeItem("Espresso", 3.00);


        List<CoffeeItem> menu = new ArrayList<>();
        menu.add(latte);
        menu.add(cappuccino);
        menu.add(espresso);

        System.out.println("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.println("Enter customer email: ");
        String email = scanner.nextLine();

        Customer customer = new Customer(name, email);


        boolean shopOpen = true;
        while (shopOpen) {


            System.out.println("Welcome to Mani G's Cafe");
            System.out.println("Menu");
            for (int i = 0; i < menu.size(); i++) {
                System.out.println(i + 1 + ". " + menu.get(i).getName() + "($" + menu.get(i).getPrice() + ")");
            }

            System.out.println("Enter the number of the drink you want to purchase (or 0 to exit):");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            if (choice == 0) {
                shopOpen = false;

                System.out.println("Shop is closing. Goodbye!");
                continue;

            }

                if (choice < 1 || choice > menu.size()) {
                    System.out.println("Invalid menu selection.");
                    continue;

                }

                CoffeeItem selectedDrink = menu.get(choice - 1);
                double priceToPay = selectedDrink.getPrice();
                double originalItemPrice = selectedDrink.getPrice();

                System.out.println("How many of this drink? ");
                int qty;

                try {
                    qty = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Enter a whole number");
                    continue;
                }

                if (qty <= 0) {
                    System.out.println("Quantity must be at least 1");
                    continue;
                }

                double unitPrice = selectedDrink.getPrice();
                double subtotal = unitPrice * qty;

                boolean rewardsApplied = false;
                double discount = 0.0;

                if (customer.isEligibleForRewards()) {
                    rewardsApplied = true;
                    discount = unitPrice;
                }

                double total = Math.max(0, subtotal - discount);

                boolean bonusPoint = subtotal > 20;

                int paidDrinks = qty - (rewardsApplied ? 1 : 0);
                for (int i = 0; i < paidDrinks; i++) {
                    customer.incrementDrinksPurchased();
                }

                if (bonusPoint) {
                    customer.incrementDrinksPurchased();
                }


            System.out.println("\n===========RECEIPT============");
            System.out.println("Customer " + customer.getName());
            System.out.println("Item: " + selectedDrink.getName());
            System.out.println("Unit Price: $%.2f%n"+ unitPrice);
            System.out.println("Quantity: " + qty);
            System.out.println("Subtotal: $%.2f%n" + subtotal);

            if (rewardsApplied){
                System.out.println("Reward Discount(1 free): -$%.2f%n" + discount);
            }

            if (rewardsApplied) {
                System.out.println("TOTAL: -$%.2f%n" + total);

                if (bonusPoint) {
                    System.out.println("Golden Ticket: +1 bonus point (Spent over $20)");
                }

                System.out.println("Drinks toward reward: " + (customer.getDrinksPurchased() % 5));
                System.out.println("====================\n");
            }




                System.out.println("Customer: " + customer.getName() + " | Drinks toward reward: " + (customer.getDrinksPurchased() % 5));

                boolean rewardApplied = false;

                if (customer.isEligibleForRewards()) {

                    System.out.println("CONGRATS! Reward reached. Next drink is on us!");
                    priceToPay = 0.0;
                    rewardApplied = true;
                }

                boolean getBonusPoint = false;
                if (originalItemPrice > 20) {
                    System.out.println("Congratulations! You get a bonus point for spending over $20");
                    customer.incrementDrinksPurchased();
                    getBonusPoint = true;
                }

                System.out.println(customer.getName() + " purchased a " + selectedDrink.getName() + "($" +
                        String.format("%.2f", priceToPay) + ")");

                    customer.incrementDrinksPurchased();





                }


            }
        }



