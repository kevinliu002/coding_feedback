package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class InputReader {
    /*
     InputReader parses the .txt file.
     See README for required .txt format
     */

    public File file;
    Scanner sc;


    public InputReader(File file) {
        this.file = file;
        try {
            sc = new Scanner(file);
        } catch (IOException e) {
            System.out.println("Error parsing file");
            e.printStackTrace();
        }
    }

    // Returns false if end of file reached.
    public boolean isNextLine() {
        return sc.hasNextLine();
    }

    public String getQuantity() {
        String quantiy = sc.next();
        return quantiy;
    }

    // Parsesproduct name
    public String getProduct() {
        String product = "";
        String current = sc.next();
        while (!current.equals("at")) {
            product = product + " " + current;
            current = sc.next();
        }
        return product;
    }

    // Returns true if product is imported.
    public boolean isImported(String product) {
        return product.contains("imported");
    }


    // Returns true if product is exempt from sales tax.
    public boolean isExempt(String product) {
        return product.contains("chocolate") || product.contains("pill") || product.contains("book");
    }

    // Parses product price.
    public String getPrice() {
        String price = sc.next();
        return price;
    }
}



