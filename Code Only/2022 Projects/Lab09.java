/*
course: CSC210
project: Lab 09
date: April 15th, 2022
author: Chris Ball
purpose: Program that displays the max consecutive increasing order substring
            and ordered subsequence of characters
*/
package lab09;
import java.util.*;

public class Lab09 {
    public static String maxSortedSubstring(String s){
        String result = "", hold = "";
        s = s.toLowerCase();
        for(int i=0;i<s.length();i++){
            if(i == 0)
                result += s.charAt(i);
            else if(s.charAt(i-1)<s.charAt(i))
                result += s.charAt(i);
            else{
                hold = result;
                result = ""+s.charAt(i);
            }
        }
        if(result.length()<hold.length())
            return hold;
        return result;
    }
    
    public static String maxSortedSubSeq(String s){
        String result = "";
        s = s.toLowerCase();
        int j = 0;
        for(int i=0;i<s.length();i++){
            if(i == 0)
                result += s.charAt(i);
            else if(result.charAt(j)<s.charAt(i)){
                result += s.charAt(i);
                j++;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String s = in.nextLine();
        System.out.println("Maximum consecutive substring is "+maxSortedSubstring(s));
        System.out.println("Maximum increasingly ordered subsequence "
                + "of characters is "+maxSortedSubSeq(s));
    }
}


/*
I don't think I understood what this lab was asking for 
because the sample run shows that "Welcome" should return "Wel" as the substring
but Wel is not in consecutive increasing order
*/