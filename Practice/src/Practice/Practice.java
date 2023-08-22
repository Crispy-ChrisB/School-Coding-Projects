/*
Class: CSC189
Project: Practice
Author: Christopher Ball
Date: 8/25/21
Purpose: Arithmetic expressions and built-in functions
 */
package Practice;

public class Practice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hey hi hello");
        System.out.println(2+3*2);
        System.out.println(34596);
        System.out.println(6/4);
        System.out.println(6.0/4);
        System.out.println(6%(-5));
        System.out.println(1/2*3);
        System.out.println(1.0/2*3);
        System.out.println("Arm" + " Leg");
        System.out.println(189+1+" is 190");
        System.out.println("1891 is "+189+1);
        System.out.println("190 is "+ (189+1));
        
        // built-in functions
        System.out.println(Math.sqrt(20));
        System.out.println(Math.sqrt(-25));
        System.out.println(Math.pow(2,3));
        System.out.println(Math.floor(2.6));
        System.out.println(Math.floor(-2.6));
        System.out.println(Math.ceil(-2.6));
        System.out.println(Math.ceil(2.6));
        System.out.println(Math.round(2.5));
        System.out.println(Math.round(-2.5));
        System.out.println(Math.round(-2.6));
        System.out.println(Math.max(3,10));
        System.out.println(Math.min(3,10));        
        System.out.println(Math.max(Math.max(4,1), 3));
        System.out.println(Math.abs(2.56));
    }
    
}
