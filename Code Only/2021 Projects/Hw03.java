/*
course: CSC189
project: Hw 03
date: Sept. 7, 2021
author: Chris Ball
purpose: read a 5 character input and print all sub-characters in a certain order
 */
package hw03;
import java.util.*;

public class Hw03 {


    public static void main(String[] args) {
        Scanner characters = new Scanner(System.in);
        Scanner digits = new Scanner(System.in);
        
        System.out.println("Enter 5 characters together:");
        String string = characters.nextLine();
        //checks if the text is actually 5 characters long
        /*  I would make this checking part better (because if you type a string
            with not 5 length multiple times, it'll let you keep it) but I don't
            know how to make my own functions.
        */
        if (string.length() > 5){
            System.out.println("The text you entered is too long. Please only input 5 characters:");
            string = characters.nextLine();
        }
        if (string.length() < 5){
            System.out.println("The text you entered is too short. Please input 5 characters:");
            string = characters.nextLine();
        }
        int endIndex = 1;
        //loops to save space
        for (int i = 0; i < 5; i++){
            System.out.println(string.substring(0,endIndex++));
        }
        endIndex = 1;
        for (int i = 0; i < 4; i++){
            System.out.println(string.substring(1,(endIndex++)+1));
        }
        endIndex = 1;
        for (int i = 0; i < 3; i++){
            System.out.println(string.substring(2,(endIndex++)+2));
        }
        //prints the last few lines; faster than looping
        System.out.println(string.substring(3,4));
        System.out.println(string.substring(3,5));
        System.out.println(string.substring(4,5));
        
        
        System.out.println("Enter 5 digits together:");
        int integer = digits.nextInt();
        int divideNumber = 10000;
        //double doubleCheck = (double) integer;
        //checks if the number entered is actually 5 digits long
        if ((integer / 10000) >= 10) {
            System.out.println("The number you entered is too long. Please only input 5 digits:");
            integer = digits.nextInt();
        }
        /*
        I couldn't actually get this one working without making the code quite long.
        if ((doubleCheck/10000) < 0){
            System.out.println("The number you entered is too short. Please input 5 digits:");
            integer = digits.nextInt();
        }
        */
        //Subtracts the beginning digits from the numbers
        double doubleA = (double) (integer - (Math.floor(integer/10000))*10000);
        int integerA = (int) doubleA;
        double doubleB = (double) (integerA - (Math.floor(integerA/1000))*1000);
        int integerB = (int) doubleB;
        double doubleC = (double) (integerB - (Math.floor(integerB/100))*100);
        int integerC = (int) doubleC;
        double doubleD = (double) (integerC - (Math.floor(integerC/10))*10);
        int integerD = (int) doubleD;
        
        for (int i = 0; i < 5; i++){
            System.out.println(integer/divideNumber);
            divideNumber = divideNumber/10;
        }
        divideNumber = 1000;
        
        for (int i = 0; i < 4; i++){
            System.out.println(integerA/divideNumber);
            divideNumber = divideNumber/10;
        }
        divideNumber = 100;
            
        for (int i = 0; i < 3; i++){
            System.out.println(integerB/divideNumber);
            divideNumber = divideNumber/10;
        }
        System.out.println(integerC/10);
        System.out.println(integerC);
        System.out.println(integerD);
    }
    
}
