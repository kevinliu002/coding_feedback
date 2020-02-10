package com.company;

public interface Product {

    String getName();

    double getOriginalPrice();

    double getTax();

    double getFinalPrice();

    int getQuantity();

    boolean isExempt();

    boolean isImported();


}