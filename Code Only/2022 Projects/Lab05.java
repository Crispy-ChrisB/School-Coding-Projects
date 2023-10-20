/*
course: CSC210
project: Lab 05
date: March 4th, 2022
author: Chris Ball
Purpose: A program that uses a recursive method to print every permuatation of a string
*/
package lab05;
import java.util.Scanner;
public class Lab05 {
    
    public static void displayPermutation(String s){
        displayPermutation("", s);
    }
    
    public static void displayPermutation(String s1, String s2){
        
        if(s2.isEmpty() == true){
            System.out.println(s1);
        }
        else{
            for(int i=0;i<s2.length();i++){
                String s1Hold = s1 + s2.charAt(i);
                String s2Hold = s2.substring(0, i) + s2.substring(i+1);
                displayPermutation(s1Hold, s2Hold);
            }
            
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String res;
        String permutate = "";
        do{
            System.out.println();
            System.out.println("Menu");
            System.out.println("---------");
            System.out.println("a: Enter a string to permutate");
            System.out.println("q: Quit");
            res = in.next();
            switch(res.toLowerCase().charAt(0)){
                case 'a':
                    System.out.println("Enter your string: ");
                    permutate = in.next();
                case 'b':
                    if(permutate == null || permutate.isBlank() == true){
                        System.out.println("String cannot be empty");
                        break;
                    }
                    else{
                        System.out.println("---------");
                        displayPermutation(permutate);
                        System.out.println("---------");
                    }
                    break;
                case 'q':
                    break;
                default:
                    System.out.println("Not an option");
            }
        }while(res.toLowerCase().charAt(0) != 'q');
    }
}