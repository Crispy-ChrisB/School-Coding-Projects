/*
course: CSC189
project: Hw10
date: Nov. 3rd, 2021
author: Chris Ball
purpose: Implement a class with methods to construct, set, and get a string
        and return the word that repeats the most.
 */
package hw10;
import java.util.Scanner;
class MyString {
    String s;
    
    MyString(){
        s = "";
    }
    
    void setMyString(String x){
        s = x;
    }
    
    String getMyString(){
        return s;
    }
    
    String getMode(){
        String holdWord = "", holdString;
        holdString = s.toLowerCase();
        String word;
        int cnt1=0, cnt2=0;
        int sp = 0, sp1 = s.indexOf(" ", sp);
        
        if(holdString.indexOf(" ") == -1)
            return holdString;
        else 
            word = holdString.substring(0,holdString.indexOf(" "));
        
        for(int i=0;i<=holdString.length()-1;i++){
            
            for(int j=i;j<=holdString.length()-1;j++){
                if(sp1 == -1){
                    holdWord = holdString.substring(j);
                    if(word.equals(holdWord))
                        cnt1++;
                    break;
                }
                else {
                    holdWord = holdString.substring(j,sp1);
                    if(word.equals(holdWord))
                        cnt1++;
                    sp = sp1+1;
                    sp1 = holdString.indexOf(" ",sp);
                    j = sp-1;
                }
                
            }
            if(cnt1>cnt2) 
//I wanted to compare the counts. cnt1 = word that repeats the most; 
//cnt2 = word being compared
//couldn't figure out what to write for cnt2 to count properly
                continue;
            else
                word = holdWord;
            
            if(sp1 == -1)
                break;
            sp = sp1+1;
            sp1 = holdString.indexOf(" ",sp);
            i = sp-1;
            
        }
        return word;
    }
}
public class Hw10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your desired text:");
        String s = in.nextLine();
        MyString str = new MyString();
        str.setMyString(s);
        System.out.println(str.getMyString());
        System.out.println(str.getMode());
        
    }
    
}
