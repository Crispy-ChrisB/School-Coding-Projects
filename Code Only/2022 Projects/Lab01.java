/*
course: CSC210
project: Lab01
date: Jan. 23rd, 2022
author: Chris Ball
purpose: Determine if a credit card number is valid or not
 */
package lab01;
import java.util.Scanner;

public class Lab01 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a credit card number: ");
        long card = in.nextLong();
        
        String res;
        
        do{
            System.out.println("What do you want to do?");
            System.out.println("a: Enter A New Card Number");
            System.out.println("b: Get The Length Of The Card's Number");
            System.out.println("c: Get A Prefix Of Digits From The Card");
            System.out.println("v: Determine If The Card Number Is Valid");
            System.out.println("q: Quit");
            res = in.next();
            
            switch(res.charAt(0)){
                case 'a':
                    System.out.print("What is your new card number?: ");
                    card = in.nextLong();
                    break;
                case 'b':
                    System.out.println("Your card is "+getSize(card)+" numbers long");
                    break;
                case 'c':
                    System.out.print("What is the size of the prefix?: ");
                    int pre = in.nextInt();
                    System.out.println(getPrefix(card, pre));
                    break;
                case 'v':
                    if(getSize(card)<13 || getSize(card)>16){
                        System.out.println("Invalid card length.");
                        break;
                    }
                    if(isValid(card)==true)
                        System.out.println("Your card is valid");
                    else
                        System.out.println("Your card is invalid");
                    break;
                case 'q':
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Not an option.");
                    break;
            }
        }while(res.charAt(0)!='q' && res.charAt(0)!='Q');
    }
    
    public static boolean isValid(long number) {
        if((sumofDoubleEvenPlace(number)+sumOfOddPlace(number))%10 == 0)
            return true;
        else
            return false;
    }
    
    public static int sumofDoubleEvenPlace(long number) {
        long hold = number;
        long sumEven = 0;
        int length = getSize(number)-1;
        for(int i=2;length>0;length -= 2){
            //int add = 0;
            hold = (long) (number/(Math.pow(10, i)));
            hold = (long) (hold*(Math.pow(10, i)));
            int add = (int) ((number-hold)/Math.pow(10, i-1));
            add = add*2;
            add = getDigit(add);
            sumEven = (long) (sumEven+add);
            i += 2;
        }
        return (int) sumEven;
    }
    
    public static int getDigit(int number) {
        if(number < 10)
            return number;
        else
            return ((number/10)+(number-10));
    }
    
    public static int sumOfOddPlace(long number) {
        long hold = number;
        long sumOdd = 0;
        int length = getSize(number);
        for(int i=1;length>0;length -= 2){
            hold = (long) (number/(Math.pow(10, i)));
            hold = (long) (hold*(Math.pow(10, i)));
            sumOdd = (long) (sumOdd+(number-hold)/Math.pow(10, i-1));
            i += 2;
        }
        return (int) sumOdd;
    }
    
    public static boolean prefixMatched(long number, int d) {
        long hold = number;
        while(hold >= 10){
            if(hold == d)
                return true;
            hold /= 10;
        }
            return false;
    }
    
    public static int getSize(long d) {
        long hold = d;
        int length = 0;
        while(hold>0){
            length++;
            hold /= 10;
        }
        return length;
    }
    
    public static long getPrefix(long number, int k) {
        if(number < k)
            return number;
        long hold = number;
        int length = 0;
        while(hold>0){
            length++;
            hold /= 10;
        }
        return (long) (number/(Math.pow(10, (length-k))));
    }
}
