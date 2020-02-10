package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ImportedProduct extends StandardProduct {
    /*
     Products with import duty and sales tax
     */


    public ImportedProduct(String name, int quantity, double price) {
        super(name, quantity, price);
        isExempt = false;
        isImported = true;
    }

    //Returns amount of tax to be added
    public double getTax() {
        double sales = 0.1 * getOriginalPrice();
        double importDuty = 0.05 * getOriginalPrice();
        BigDecimal a = new BigDecimal(0.05 * Math.ceil(sales * 20));
        BigDecimal b = a.setScale(2, RoundingMode.DOWN);

        BigDecimal c = new BigDecimal(0.05 * Math.ceil(importDuty * 20));
        BigDecimal d = c.setScale(2, RoundingMode.DOWN);
        return b.doubleValue() + d.doubleValue();
    }

    //Returns final product price
    public double getFinalPrice() {

        return getOriginalPrice() + getTax();
    }

}
