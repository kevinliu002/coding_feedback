package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StandardProduct implements com.company.Product {
    /*
    Standard product with sales tax only.
    */


    public String name;
    public int quantity;
    public double price;
    public boolean isExempt;
    public boolean isImported;


    public StandardProduct(String name, int quantity, double price) {
        //Sales tax no import duty.
        isImported = false;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //Returns product name
    @Override
    public String getName() {
        return this.name;
    }

    //Returns original product price
    @Override
    public double getOriginalPrice() {
        return this.price;
    }

    //Returns amount of tax added
    @Override
    public double getTax() {
        BigDecimal a = new BigDecimal(0.05 * Math.ceil(0.1 * getOriginalPrice() * 20));
        BigDecimal b = a.setScale(2, RoundingMode.DOWN);
        return b.doubleValue();
    }

    //Returns final price
    @Override
    public double getFinalPrice() {
        return getOriginalPrice() + getTax();
    }

    //Returns product quantity
    @Override
    public int getQuantity() {
        return this.quantity;
    }

    //Returns true if product is exempt from sales tax
    @Override
    public boolean isExempt() {
        return this.isExempt;
    }


    //Returns true if product is imported
    @Override
    public boolean isImported() {
        return this.isImported;
    }
}
