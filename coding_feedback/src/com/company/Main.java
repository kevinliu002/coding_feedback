package com.company;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        /* *
         This is the main exeuction point and will print out the
         receipt details when given an input.txt file stored in the input directory
         with the correct format. See README for assumptions and other information
         about this program.
          */

        //Preparing .txt file to be read.
        File dir = new File("./src/com/company/input/");
        File[] diretoryListing = dir.listFiles();

        //Reads each .txt file and prints out reciept details.
        for (File child : diretoryListing) {

            //Special edge case to handle directory irregularites found in MacOS.
            if (child.toString().contains("DS_Store")) {
                break;
            }
            try {
                InputReader input = new InputReader(child);
                ShoppingCart cart = new ShoppingCart();

                while (input.isNextLine()) {

                    int quantity = Integer.parseInt(input.getQuantity());
                    String product = input.getProduct();
                    Double price = Double.parseDouble(input.getPrice());

                    //Case 1: Product is exempted from sales tax but imported.
                    if (input.isExempt(product) && input.isImported(product)) {
                        ExemptImportedProduct newProduct = new ExemptImportedProduct(product, quantity, price);
                        cart.addCart(newProduct);

                        //Case 2: Product is exempted from sales tax and is not imported.
                    } else if (input.isExempt(product)) {
                        ExemptProduct newProduct = new ExemptProduct(product, quantity, price);
                        cart.addCart(newProduct);

                        //Case 3: Product is not exempted from sales tax and is imported.
                    } else if (input.isImported(product)) {
                        ImportedProduct newProduct = new ImportedProduct(product, quantity, price);
                        cart.addCart(newProduct);

                        //Case 4: All other cases; product is is not exempted from sales tax and is not imported.
                    } else {
                        StandardProduct newProduct = new StandardProduct(product, quantity, price);
                        cart.addCart(newProduct);
                    }
                }
                //Print receipt details
                cart.printCart();
                cart.printSalesTax();
                cart.printTotal();

            } catch (Exception e) {
                System.out.println("Error parsing input file, please check format.");
            }
        }
    }
}