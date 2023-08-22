/*
course: CSC189
project: Lab09
date: Oct. 22, 2021
author: Chris Ball
purpose: Print many substrings of string S
*/
package lab09;
class Substrings {
    void printSub1(String S){
        int len = S.length();
        for(int i=1;i<=len;i++)
            for(int j=len;j>0+i-1;j--)
                System.out.print(S.substring(i-1,len-j+i)+", ");
        System.out.println();
    }
    
    void printSub2(String S){
        int len = S.length();
        for(int i=1;i<=len;i++)
            for(int j=0;j<i;j++)
                System.out.print(S.substring(j,i)+", ");
        System.out.println();
    }
    
    void printSub3(String S){
        int len = S.length();
        int cnt;
        for(int i=1;i<=len;i++){
            cnt=i;
            for(int j=len;j>=i;j--){
                System.out.print(S.substring(len-cnt,j)+", ");
                cnt++;
            }
        }
        System.out.println();
    }
    
    void printSub4(String S){
        int len = S.length();
        for(int i=0;i<len;i++)
            for(int j=0;j<=i;j++)
                System.out.print(S.substring(i-j,len-j)+", ");
        System.out.println();
    }
}
public class Lab09 {
    public static void main(String[] args) {
        Substrings str1 = new Substrings();
        str1.printSub1("abcd");
        str1.printSub2("abcd");
        str1.printSub3("abcd");
        str1.printSub4("abcd");
    }
    
}
