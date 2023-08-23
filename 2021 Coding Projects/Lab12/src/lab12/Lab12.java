/*
course: CSC189
project: Lab 12
date: Nov. 12, 2021
author: Chris Ball
purpose: A program to find all prime numbers less than or equal to a given positive integer.
 */
package lab12;
import java.util.Scanner;

class SieveOfEratosthenes {

    final int MAXSIZE = 100;
    boolean p[];
    int n;

    SieveOfEratosthenes() {
        p = new boolean[MAXSIZE];
        n = 0;
    }

    void setP(int nn) {
        n = nn;
        
        //Initialize p: p[0], p[1] are not used
        //all the numbers from 2 to n are assumed true initially
        p = new boolean[n]; //I set all to true in sieve
    }

    //change all p[i]s to false if i is not prime.
    //For n = 15,
    //     0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15
    //p =  ?  ?  t  t  t  t  t  t  t  t  t  t  t  t  t  t   all true initially
    //to
    //     0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15
    //p =  ?  ?  t  t  f  t  f  t  f  f  f  t  f  t  f  f   all composites changed to false
    void sieve() {
        for(int i=2;i<n;i++)
            p[i] = true;
        for(int i=2;i<n;i++){
            int cnt = 0;
            if(p[i] == true)
                for(int j=(i*i);j<n;j=((i*i)+(cnt*i))){
                    p[j] = false;
                    cnt++;
                }
        }
    }

    void printp() {
        sieve();
        for(int i=2;i<n;i++)
            if(p[i]==true)
                System.out.println(i);
    }
}

public class Lab12 {

    public static void main(String[] args) {
        SieveOfEratosthenes mc = new SieveOfEratosthenes();
        Scanner in = new Scanner(System.in);
        
        int n = 0;
        String res;
        do{
            System.out.println("What do you want to do?");
            System.out.println("1: Set your number");
            System.out.println("2: Find all prime numbers less than or equal to your number");
            System.out.println("3: Exit");
            res = in.next();
            switch(res.charAt(0)){
                case '1':
                    System.out.print("What do you want your new number to be? ");
                    n = in.nextInt();
                    mc.setP(n);
                    break;
                case '2':
                    if(n > 0){
                        System.out.println("Here are all the prime numbers less than or equal to "+n);
                        mc.printp();
                        break;
                    }
                    if(n <= 0)
                        System.out.println("That number is too small. Please "
                                + "set your number to something greater than 0");
                    break;
                case '3':
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("That is not an option.");
                    
            }
        }while(res.charAt(0) != '3');
    }
}
