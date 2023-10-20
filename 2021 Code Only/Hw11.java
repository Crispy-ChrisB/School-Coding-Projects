/*
course: CSC189
project: Hw11
date: Nov. 17th, 2021
author: Chris Ball
purpose: Manipulate a given string parameter b directly
            without changing it to a numeric value
*/
package hw11;

import java.util.Scanner;

class BinaryStrings {
    
    String incBinary(String b){
        String bEnd = "";
        int remainder;
        int i = b.length()-1;
        if(b.charAt(b.length()-1)=='1')
            remainder = 1;
        else {
            bEnd = "1";
            remainder = 0;
            i--;
        }
        for(;i>=0;i--){
            if(b.charAt(i)=='0'){
                if(remainder == 0)
                    bEnd = "0"+bEnd;
                else{
                    bEnd = "1"+bEnd;
                    remainder = 0;
                }
            }
            if(b.charAt(i)=='1'){
            
                if(remainder == 0)
                    bEnd = "1"+bEnd;
                else
                    bEnd = "0"+bEnd;
            }
        }
        if(remainder==1)
            bEnd = '1'+bEnd;
        return bEnd;
    }
    
    String decBinary(String b){
        String bEnd = "";
        while(b.charAt(0)=='0')
            b = b.substring(1);
        if(b.charAt(b.length()-1)=='1')
            bEnd = b.substring(0,b.length()-1)+"0";
        else {
            int remainder = -1;
            for(int i=b.length()-1;i>=0;i--){
                if(b.charAt(i)=='0'){
                    if(remainder == -1){
                        bEnd = "1"+bEnd;
                        remainder = -1;
                    }
                    else{
                        bEnd = "0"+bEnd;
                        remainder = 0;
                    }
                }
                if(b.charAt(i)=='1'){
                    if(remainder == 0)
                        bEnd = "1"+bEnd;
                    else{
                        bEnd = "0"+bEnd;
                        remainder = 0;
                    }
                }
            }
        }
        while(bEnd.charAt(0)=='0')
            bEnd = bEnd.substring(1);
        return bEnd;
    }
    
    void printBinary(int n){
        String b = "0";
        for(int i=0;i<=n;i++){
            System.out.println(b);
            b = incBinary(b);
        }   
    }
    
    int checkBinary(String b){
        for(int i=0;i<b.length();i++)
            if(b.charAt(i)!='1' && b.charAt(i)!='0')
                return 0;
        return 1;
    }
}
public class Hw11 {
    public static void main(String[] args) {
        BinaryStrings bin = new BinaryStrings();
        Scanner in = new Scanner(System.in);
        
        String res, b;
        
        do{
            System.out.println("What do you want to do?");
            System.out.println("i: Increase Binary");
            System.out.println("d: Decrease Binary");
            System.out.println("p: Print Binary");
            System.out.println("q: Quit");
            res = in.next();
            
            switch(res.charAt(0)){
                case 'i':
                    System.out.println("What binary number do you "
                            + "want to add 1 to?");
                    b = in.next();
                    if(bin.checkBinary(b)==1)
                        System.out.println(b+"+1 = "+bin.incBinary(b));
                    else System.out.println("That is not a binary number.");
                    break;
                case 'd':
                    System.out.println("What binary number do you "
                            + "want to subtract 1 from?");
                    b = in.next();
                    if(bin.checkBinary(b)==1)
                        System.out.println(b+"-1 = "+bin.decBinary(b));
                    else System.out.println("That is not a binary number.");
                    break;
                case 'p':
                    System.out.println("How many numbers do you "
                            + "want to print binary numbers up to?");
                    int n = in.nextInt();
                    bin.printBinary(n);
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
}