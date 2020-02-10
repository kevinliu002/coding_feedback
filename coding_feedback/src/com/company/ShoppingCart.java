package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class ShoppingCart {
    /*
    Shopping cart keeps track of al items that have been seen.
    */


    double totalPrice;
    double salesTax;
    ArrayList<StandardProduct> cart;


    public ShoppingCart() {
        totalPrice = 0;
        salesTax = 0;
        cart = new ArrayList<>();
    }

    // Adds product to cart.
    public void addCart(StandardProduct product) {
        cart.add(product);
        salesTax += product.getTax();
        totalPrice += product.getOriginalPrice();
    }

    // Prints product quantity, name, and price.
    public void printCart() {
        for (int i = 0; i < cart.size(); i++) {
            Product current = cart.get(i);
            System.out.print(((StandardProduct) current).quantity);
            System.out.print(current.getName());
            System.out.print(": ");
            System.out.printf("%.2f", current.getFinalPrice());
            System.out.println();
        }
    }

    //Prints cumulative sales tax.
    public void printSalesTax() {
        BigDecimal a = new BigDecimal(0.05 * Math.ceil(salesTax * 20));
        BigDecimal b = a.setScale(2, RoundingMode.DOWN);
        System.out.println("Sales Taxes: " + b);
    }

    //Prints cumulative total.
    public void printTotal() {
        System.out.printf("Total: " + "%.2f", totalPrice + salesTax);
        System.out.println("\n");
    }

}
