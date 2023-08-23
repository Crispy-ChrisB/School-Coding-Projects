/*
course: CSC189
project: lab02
date: Aug. 27
author: Christopher Ball
purpose: This program reads a monetary amount in cents and prints the smallest possible number of coins equaling the amount
 */
package lab02;
import java.util.Scanner;

public class Lab02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int amounts; //input variables
        int originalAmount;
        int dollars, quarters, dimes, nickels, pennies; //output variables
        
        System.out.println("Enter an amount in cents:");
        amounts = in.nextInt();
        originalAmount = amounts;
        
        //Steps for computing money.
        
        dollars = amounts/100;
        amounts = amounts%100;
        quarters = amounts/25;
        amounts = amounts%25;
        dimes = amounts/10;
        amounts = amounts%10;
        nickels = amounts/5;
        amounts = amounts%5;
        pennies = amounts/1;
        
        //Output
        System.out.println(originalAmount+" converted to as little change as possible is: ");
        System.out.println(dollars+" Dollars");
        System.out.println(quarters+" Quarters");
        System.out.println(dimes+" Dimes");
        System.out.println(nickels+" Nickels");
        System.out.println(pennies+" Pennies");
    }
    
}
