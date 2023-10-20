/*
course: CSC189
project: Hw 06
date: Sept. 29, 2021
author: Chris Ball
purpose: Rank 5 given integers as if they were a poker hand
*/
package hw06;
import java.util.*;
public class Hw06 {
    static void handRanking(int n1,int n2,int n3,int n4,int n5) {
        int h = 0;
        //pass 1
        if(n1>n2){
            h=n1;
            n1=n2;
            n2=h;
        }
        if(n2>n3){
            h=n2;
            n2=n3;
            n3=h;
        }
        if(n3>n4){
            h=n3;
            n3=n4;
            n4=h;
        }
        if(n4>n5){
            h=n4;
            n4=n5;
            n5=h;
        }
        //pass 2
        if(n1>n2){
            h=n1;
            n1=n2;
            n2=h;
        }
        if(n2>n3){
            h=n2;
            n2=n3;
            n3=h;
        }
        if(n3>n4){
            h=n3;
            n3=n4;
            n4=h;
        }
        //pass 3
        if (n1>n2) {
            h=n1;
            n1=n2;
            n2=h;
        }
        if (n2>n3) {
            h=n2;
            n2=n3;
            n3=h;
        }
        //pass 4
        if(n1>n2){
            h=n1;
            n1=n2;
            n2=h;
        }
        //------------------------------
        String rank;
        //Full House
        if(((n1==n2) && (n3==n5)) || ((n1==n3) && (n4==n5))) rank = ("Full House("+n1+", "+n5+")");
        //3 or 4 of a kind
        else if(n1==n4 || n2==n5) rank = ("Four-of-a-kind("+n2+")");
        else if(((n1==n3) && n4!=n5) || (n2==n4) || ((n3==n5) && n1!=n2)) rank = ("Three-of-a-kind("+n3+")");
        //2 or 1 pair
        else if((n1==n2 && n3==n4 && n1!=n3 && n4!=n5) || (n2==n3 && n4==n5 && n1!=n2 && n3!=n4) || (n1==n2 && n4==n5 && n2!=n3 && n3!=n4)) rank = ("Two Pair("+n2+", "+n4+")");
        else if(n1==n2 && n2!=n3 && n3!=n4 && n4!=n5) rank = ("One Pair("+n1+")");
        else if(n2==n3 && n1!=n2 && n3!=n4 && n4!=n5) rank = ("One Pair("+n2+")");
        else if(n3==n4 && n2!=n3 && n1!=n2 && n4!=n5) rank = ("One Pair("+n3+")");
        else if(n4==n5 && n2!=n3 && n3!=n4 && n1!=n2) rank = ("One Pair("+n4+")");
        //straight
        else if(n2==n1+1 && n3==n2+1 && n4==n3+1 && n5==n4+1) rank = ("Straight("+n5+")");
        else if(n1==1 && n3==n2+1 && n4==n3+1 && n4==n5-1 && n5==13)rank = ("Straight("+n1+")");
        //high card
        else if(n1==1) rank = ("High Card("+n1+")");
        else rank = ("High Card("+n5+")");
        
        System.out.println(rank);
    }
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        int n1,n2,n3,n4,n5;
        System.out.print("Enter five integers in a range (1-13): ");
        n1 = key.nextInt();
        n2 = key.nextInt();
        n3 = key.nextInt();
        n4 = key.nextInt();
        n5 = key.nextInt();
        
        handRanking(n1, n2, n3, n4, n5);
        
    }
}