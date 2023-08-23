/*
course: CSC210
project: Hw 06
date: March 10th, 2022
author: Chris Ball
purpose: Read a string and output the reversed string and substrings
*/
package hw06;
import java.util.Scanner;

public class Hw06 {

    public static void reverseS(String s){
        reverseS(s, s.length()-1);
    }
    public static void reverseS(String s, int i){
        if(i == 0){
            System.out.print(s.charAt(0));
            System.out.println();
        }
        else{
            System.out.print(s.charAt(i));
            s = s.substring(0, i);
            reverseS(s, s.length()-1);
        }
    }
    
    public static void printSub1(String s){
        printSub1(s,s,s.length(),0);
    }
    public static void printSub1(String s, String s1, int i, int cnt){
        if(s1.isEmpty())
            if(cnt == s.length())
                System.out.println();
            else{
                cnt++;
                s1 = s.substring(cnt);
                printSub1(s1);
            }
        else{
            System.out.print(s1.substring(cnt, i)+" ");
            s1 = s.substring(0, i);
            printSub1(s, s1, s1.length()-1,cnt);
        }
    }
    
    public static void printSub2(String s){
        printSub2(s,0,1);
    }
    public static void printSub2(String s, int iCnt, int jCnt){
        if(iCnt == 1)
            System.out.println();
        else{
            for(int i=iCnt;i<s.length();i++){
                for(int j=i+1;j<=s.length();j++){
                    System.out.print(s.substring(i, j)+" ");
                }
            }
            iCnt++;
            jCnt++;
            printSub2(s,iCnt,jCnt);
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;
        
        do{
            System.out.println("---------------");
            System.out.println("Menu");
            System.out.println("1: Enter a string");
            System.out.println("q: Quit");
            System.out.println("---------------");
            res = in.next();
            switch(res.toLowerCase().charAt(0)){
                case '1':
                    System.out.print("Please input a string: ");
                    String s = in.next();
                    System.out.print("The reversed string: ");
                    reverseS(s);
                    System.out.print("The substrings of the input string: ");
                    printSub1(s);
                    System.out.print("The substrings of the input string: ");
                    printSub2(s);
                    break;
                case 'q':
                    break;
                default:
                    System.out.println("Not an option.");
            }
        }while(res.toLowerCase().charAt(0) != 'q');
    }
}