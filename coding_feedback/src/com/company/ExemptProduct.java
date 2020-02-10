
package com.company;

public class ExemptProduct extends StandardProduct {
    //Product without any sales tax or import duty.

    public ExemptProduct(String name, int quantity, double price) {
        super(name, quantity, price);
        isExempt = true;
        isImported = false;
    }

    //Returns final price
    public double getFinalPrice() {
        return getOriginalPrice();
    }

    //Returns amount of tax
    public double getTax() {
        return 0;
    }

}


