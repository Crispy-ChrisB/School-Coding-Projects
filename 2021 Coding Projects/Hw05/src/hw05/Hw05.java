/*
course: CSC189
project: Hw 05
date: Sept. 22, 2021
author: Chris Ball
purpose: Slot machine
*/
package hw05;
import java.util.*;
public class Hw05 {
    public static void main(String[] args) {
        Random rand = new Random();

        System.out.println("How Lucky Are You? Match To Win!");
        System.out.println("2 Numbers: $10"+"\n"+"3 Numbers: $100"+"\n"+"4 Numbers: $1,000"+"\n"+"5 Numbers: $10,000");
        int r1, r2, r3, r4, r5; //5 digits generated
        int t1, t2, t3, t4, h;
        double prize;

        r1 = rand.nextInt(9) + 1; //generate an integer between 1 and 9
        r2 = rand.nextInt(9) + 1;
        r3 = rand.nextInt(9) + 1;
        r4 = rand.nextInt(9) + 1;
        r5 = rand.nextInt(9) + 1;
        System.out.println(r1 + ", " + r2 + ", " + r3 + ", " + r4 + ", " + r5);
        
        //code for tallying money
        //pass 1
        if(r1>r2){
            h=r1;
            r1=r2;
            r2=h;
        }
        if(r2>r3){
            h=r2;
            r2=r3;
            r3=h;
        }
        if(r3>r4){
            h=r3;
            r3=r4;
            r4=h;
        }
        if(r4>r5){
            h=r4;
            r4=r5;
            r5=h;
        }
        //pass 2
        if(r1>r2){
            h=r1;
            r1=r2;
            r2=h;
        }
        if(r2>r3){
            h=r2;
            r2=r3;
            r3=h;
        }
        if(r3>r4){
            h=r3;
            r3=r4;
            r4=h;
        }
        //pass 3
        if (r1 > r2) {
            h = r1;
            r1 = r2;
            r2 = h;
        }
        if (r2 > r3) {
            h = r2;
            r2 = r3;
            r3 = h;
        }
        //pass 4
        if(r1>r2){
            h=r1;
            r1=r2;
            r2=h;
        }
        //Determines the prize
        if(r1==r5)prize = 10000;
        else if(r1==r4)prize = 1000;
        else if(r1==r3)prize = 100;
        else if(r1==r2)prize = 10;
        else prize = 0;
        
        if(r2==r5 && prize<10000)prize = prize + 1000;
        else if(r2==r4 && prize<1000)prize = prize + 100;
        else if(r2==r3 && prize<100)prize = prize + 10;
        
        if(r3==r5 && prize<1000)prize = prize + 100;
        else if(r3==r4 && prize<100)prize = prize + 10;
        
        if(r4==r5 && r3!=r5)prize = prize + 10;
        
        System.out.println("You won $" + prize + ".");
    }
    
}
