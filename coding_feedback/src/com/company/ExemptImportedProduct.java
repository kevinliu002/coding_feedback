package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExemptImportedProduct extends StandardProduct {
    /*
    Product with no sales tax but import duty.
     */

    public ExemptImportedProduct(String name, int quantity, double price) {
        super(name, quantity, price);
        isExempt = true;
        isImported = true;
    }

    //Returns amount of tax to be added
    public double getTax() {
        BigDecimal a = new BigDecimal(0.05 * Math.ceil(0.05 * getOriginalPrice() * 20));
        BigDecimal b = a.setScale(2, RoundingMode.DOWN);
        return b.doubleValue();
    }

    //Return final product price
    public double getFinalPrice() {
        return getTax() + getOriginalPrice();
    }

}
