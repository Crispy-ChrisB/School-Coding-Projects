/*
course: CSC189
project: Lab08
date: 10/15/21
author: Christopher Ball
purpose: Plot triangles based off integer n.
*/
package lab08;
import java.util.*;
public class Lab08 {
    public static void plotTri1(int n){
        int k = 1;
        for(int i=n;i>0;i--){
            for(int j=1;j<=i;j++){
                System.out.printf("%-3d",k);
                k++;
            }
        System.out.println();
        }
    }
    public static void plotTri2(int n){
        for(int i=1;i<=n;i++){
            int k = i;
            for(int j=1;j<=i;j++){
                System.out.printf("%3d",k);
                k = k+n-j;
            }
            System.out.println();
        }
    }
    public static void plotTri3(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++)
                System.out.printf("%3s"," ");
            int k = 1;
            for(int j=1;j<=i;j++){
                System.out.printf("%3d",k);
                k *= 2;
            }
            k /= 4;
            for(int j=1;j<i;j++){
                System.out.printf("%3d",k);
                k /= 2;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an integer:");
        int n = in.nextInt();
        
        plotTri1(n);
        plotTri2(n);
        plotTri3(n);
    }   
}