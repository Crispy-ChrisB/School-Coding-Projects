/*
course: CSC189
project: Lab 05 
date: Sept. 17, 2021
author: Chris Ball
purpose: 
 */
package lab05;
import java.util.*;
public class Lab05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter a sentence consisting of 5 lower-case words:");
        String s = in.nextLine();
        String w1, w2, w3, w4, w5, cut; //Variables for each word
        w1 = s.substring(0, (s.indexOf(" ")));
        w2 = s.substring(s.indexOf(" ")+1, s.indexOf(" ", (s.indexOf(" ")+1)));
        cut = s.substring(s.indexOf(" ", (s.indexOf(" ")+1)));
        cut = cut.trim();
        w3 = cut.substring(0, (cut.indexOf(" ")));
        w4 = cut.substring(cut.indexOf(" ")+1, cut.indexOf(" ", (cut.indexOf(" ")+1)));
        w5 = cut.substring(cut.lastIndexOf(" ")+1);
        
        //a
        String longest;
        if (w1.length() == w2.length() || w1.length() > w2.length()) longest = w1;
        else longest = w2;
        if (w3.length() > longest.length()) longest = w3;
        if (w4.length() > longest.length()) longest = w4;
        if (w5.length() > longest.length()) longest = w5;
        System.out.println(longest);
        
        //b
        String hold;
        //pass 1
        if (w1.compareTo(w2) > 0){
            hold = w1;
            w1 = w2;
            w2 = hold;
        }
        if (w2.compareTo(w3) > 0){
            hold = w2;
            w2 = w3;
            w3 = hold;
        }
        if (w3.compareTo(w4) > 0){
            hold = w3;
            w3 = w4;
            w4 = hold;
        }
        if (w4.compareTo(w5) > 0){
            hold = w4;
            w4 = w5;
            w5 = hold;
        }
        //pass 2
        if (w1.compareTo(w2) > 0){
            hold = w1;
            w1 = w2;
            w2 = hold;
        }
        if (w2.compareTo(w3) > 0){
            hold = w2;
            w2 = w3;
            w3 = hold;
        }
        if (w3.compareTo(w4) > 0){
            hold = w3;
            w3 = w4;
            w4 = hold;
        }
        //pass 3
        if (w1.compareTo(w2) > 0){
            hold = w1;
            w1 = w2;
            w2 = hold;
        }
        if (w2.compareTo(w3) > 0){
            hold = w2;
            w2 = w3;
            w3 = hold;
        }
        //pass 4
        if (w1.compareTo(w2) > 0){
            hold = w1;
            w1 = w2;
            w2 = hold;
        }
        
        System.out.println(w1+" "+w2+" "+w3+" "+w4+" "+w5);
    }
    
}