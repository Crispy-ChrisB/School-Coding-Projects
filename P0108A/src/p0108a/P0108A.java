//purpose: simple if statement
package p0108a;

import java.util.*;
public class P0108A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n;
        System.out.println("Enter an integer:");
        n = in.nextInt();
        
        if (n%2 == 0)
            System.out.println("Your number is even.");
        else
            System.out.println("Your number is odd.");
        
        int n1, n2;
        System.out.println("Enter 2 integers:");
        n1 = in.nextInt();
        n2 = in.nextInt();
        
        if (n1 > n2){
            System.out.println(n1+" is greater than "+n2+".");
        }
        else if(n1 < n2){
            System.out.println(n2+" is greater than "+n1+".");
        }
        else
            System.out.println(n1+" is equal to "+n2+".");
    }
}