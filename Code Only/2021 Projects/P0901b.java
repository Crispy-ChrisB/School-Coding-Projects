/*
Purpose: cast amd data type connections
 */
package p0901b;

import java.util.*;
public class P0901b {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double amount;
        int dollars, cents;
        System.out.println("Enter an amount of money: ");
        amount = in.nextDouble();
        dollars = (int)amount;
        cents = (int)Math.round((amount-dollars)*100);
        System.out.println(amount+" is $"+dollars+" and "+cents+" cents.");
        
        
        System.out.println("Enter an amount of money: ");
        String strAmount = in.next();
        int index = strAmount.indexOf(".");
        dollars = Integer.parseInt(strAmount.substring(0, index));
        cents = Integer.parseInt(strAmount.substring(index+1, index+3));
        System.out.println(amount+" is $"+dollars+" and "+cents+" cents.");
        
        //Calculate the post charge of a mail
        //for the first ounce 25 cents
        //additional ounces: 30 cents per ounce
        double weight;
        int cost;
        
        System.out.println("Enter the weight of the letter:");
        weight = in.nextDouble();
        cost = (int)(25+30*(Math.ceil(weight-1)));
        
        System.out.println("The weight of the letter is "+weight+" ounces "
                + "and the cost to mail it is "+cost+" cents.");
    }
    
}
