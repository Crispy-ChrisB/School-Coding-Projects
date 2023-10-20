/*
course: CSC189
project: Lab10
date: Oct. 29, 2021
author: Chris Ball
purpose: Return a given string with each character 
         coupled by its frequency
 */
package lab10;
import java.util.*;
class MyString {
    String S;
    
    void setMyString(){
        Scanner string = new Scanner(System.in);
        System.out.println("Enter your string: ");
        S = string.nextLine();
    }
    String getS(){
        return S;
    }
    String getCount(){
        String R = "";
        char hold;
        for(int i=0;i<=S.length()-1;i++){
            int cnt = 0;
            hold = S.charAt(i);
            
            if(R.indexOf(hold) == -1) {
                for(int j=i;j<=S.length()-1;j++)
                    if(S.charAt(j)==hold)
                        cnt++;
                R = R+hold+cnt;
            }
        }
        return R;
    }
}
public class Lab10 {
    public static void main(String[] args) {
        MyString test = new MyString();
        test.setMyString();
        System.out.println(test.getS());
        System.out.println(test.getCount());
        
    }
    
}
