/*
course: CSC189
project: Hw 04
date: Sept. 15, 2021
author: Chris Ball
purpose: Decide if a triangle can be formed from 3 sides & what type of triangle it is
 */
package hw04;
import java.util.*;
public class Hw04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        double s1, s2, s3, max, short1, short2;
        
        System.out.println("Enter 3 sides to see if it is a triangle:");
        System.out.println("Side 1:");
        s1 = in.nextDouble();
        System.out.println("Side 2:");
        s2 = in.nextDouble();
        System.out.println("Side 3:");
        s3 = in.nextDouble();
        
        if(s1>s2) {
            max = s1;
            short1 = s2;
            short2 = s3;
        }
        else {
            max = s2;
            short1 = s1;
            short2 = s3;
        }
        if (s3>s1 && s3>s2) {
            max = s3;
            short1 = s1;
            short2 = s2;
        }
        if(short1+short2 <= max) System.out.println("Can't form a triangle.");
        else if(Math.pow(short1, 2)+Math.pow(short2, 2) > Math.pow(max, 2)) System.out.println("acute");
        else if(Math.pow(short1, 2)+Math.pow(short2, 2) == Math.pow(max, 2)) System.out.println("right");
        else if(Math.pow(short1, 2)+Math.pow(short2, 2) < Math.pow(max, 2)) System.out.println("obtuse");
    }
    
}
