/*
course: CSC210
project: Lab 02
date: Jan. 28th/30th, 2022
author: Chris Ball
purpose: Find a maximum square submatrix whose elements are all 1s
*/
package lab02;
import java.util.*;

public class Lab02 {
    
    public static int[] findLargestBlock(int[][] m){
        int S[][] = new int[m.length][m.length];
        
        for(int i=0;i<m.length;i++)
            S[0][i] = m[0][i];
        for(int i=0;i<m.length;i++)
            S[i][0] = m[i][0];
        
        for(int i=1;i<m.length;i++)
            for(int j=1;j<m.length;j++){
                if(m[i][j] == 1)
                    S[i][j] = (Math.min(Math.min(S[i][j-1],S[i-1][j]),S[i-1][j-1]))+1;
                else if(m[i][j] == 0)
                    S[i][j] = 0;
            }
        
        int max = S[0][0];
        int xCoord=0, yCoord=0;
//this is a little confusing because when you graph x,y , x is across and y is up and down.
        for(int i=0;i<S.length;i++)
            for(int j=0;j<S.length;j++)
                if(max<S[i][j]){
                    max = S[i][j];
                    xCoord = i;
                    yCoord = j;
                }
        int subSquare[] = {(xCoord-max+1),(yCoord-max+1),max};
        return subSquare;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter the number of rows in the square matrix: ");
        int x = in.nextInt();
        int M[][] = new int[x][x];
        System.out.println("Enter the matrix row by row (separate "
                + "each number with a space): ");
        for(int i=0;i<x;i++){
            for(int j=0;j<x;j++){
                M[i][j] = in.nextInt();
            }
        }
        int ref[] = findLargestBlock(M);
        System.out.println("The maximum square submatrix is at ("
                + ref[0]+","+ref[1]+") with size "+ref[2]);
    } 
}
