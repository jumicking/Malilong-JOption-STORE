/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package myc.store_dialogbox;

import javax.swing.JOptionPane;

/**
 *
 * @author Abram
 */
public class MycStore_dialogbox {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean main = true;
        while (main) {
            JOptionPane.showMessageDialog(null, "Welcome to Jumayks ice cream shop");
            String response = JOptionPane.showInputDialog(null, "Would you like to buy ice cream? yes/no");

            main = false;
            boolean choice = false;
            double totalcost = 0;
            double subtotal = 0;

            while (response.equalsIgnoreCase("yes")) {

                String message =""" 
                           FLAVOR   \t  PRICE   \t BARCODE
                              Mocha     \t 30        \t 1
                              Choco     \t 25        \t 2
                              Vanilla     \t 20        \t 3
                              Mango     \t 35        \t 4
                              Ube          \t 28         \t 5
                           \n 15% Discount for 500.00 Php worth of purchase!!!
                            \n Input barcode number:""";

                int input2 = Integer.parseInt(JOptionPane.showInputDialog(null, message));

                
                double price = 0;
                String productName = "";

                switch (input2) {
                    case 1 -> {
                        price = 30;
                        productName = "Mocha";
                        choice = true;
                    }
                    case 2 -> {
                        price = 25;
                        productName = "Choco";
                        choice = true;
                    }
                    case 3 -> {
                        price = 20;
                        productName = "Vanilla";
                        choice = true;
                    }
                    case 4 -> {
                        price = 35;
                        productName = "Mango";
                        choice = true;
                    }
                    case 5 -> {
                        price = 28;
                        productName = "Ube";
                        choice = true;
                    }
                    default -> {
                        JOptionPane.showMessageDialog(null, "Invalid choice.");
                        choice = false;
                    }

                }
                if (choice) {
                    double quantity = Double.parseDouble(JOptionPane.showInputDialog(null, "You selected: " + productName + "\n cost: PHP " + price + "\n Enter quantity:"));
                    subtotal = price * quantity;
                    totalcost += subtotal;
                    JOptionPane.showMessageDialog(null, "Subtotal: " + quantity + "*" + price + " = PHP " + subtotal);
                    response = JOptionPane.showInputDialog(null, " Would you like to purchase another item? (yes/no)");

                }
                double discount = 0.15;
                double totaldis = 0;
                double total = 0;

                if (totalcost > 500) {
                    totaldis = totalcost * discount;
                    total = totalcost - totaldis;
                    JOptionPane.showMessageDialog(null, "YOU HAVE SUCCESSFULLY ATTAINED 15% DISCOUNT");

                } else {
                    total = totalcost;
                }
                if (response.equalsIgnoreCase("no")) {
                    JOptionPane.showMessageDialog(null, "Overall total: PHP " + total);

                    double payment = 0;

                    do {

                        payment = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the amount of money to pay: "));

                        if (payment < total) {
                            JOptionPane.showMessageDialog(null, "Insufficient funds. You need at least PHP " + (total - payment) + " more.");

                        } else {
                            double change = payment - total;
                            JOptionPane.showMessageDialog(null, "Your change is PHP " + change);

                        }
                    } while (payment < total);
                    main = true;
                    JOptionPane.showMessageDialog(null, ".....................THANKYOU FOR BUYING........................");
                }
            }
        }
    }
}
