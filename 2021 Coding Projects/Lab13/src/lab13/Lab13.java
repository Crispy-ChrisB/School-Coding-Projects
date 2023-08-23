/*
course: CSC189
project: Lab13
date: Nov. 19th, 2021
author: Chris Ball
purpose: Make a histogram
 */
package lab13;
import java.util.Scanner;

class Histogram {
    String text;
    
    Histogram(){
        text = "I love problem-solving.";
    }
    
    void setText(String t){
        text = t;
    }
    
    void drawHistogram(){
        int A[] = new int[26];
        text = text.toLowerCase();
        
        for(int i=0;i<text.length();i++){
            char hold = text.charAt(i);
            if(hold>='a'&&hold<='z')
                A[hold-'a']++;
        }
        int max = A[0];
        for(int i=0;i<26;i++)
            if(max<A[i])
                max = A[i];
        
        for(int i=0;i<max;max--){
            int j = 0;
            while(j<26){
                if(max==A[j]){
                    System.out.print("* ");
                    A[j]--;
                }
                else
                    System.out.print("  ");
                j++;
            }
            System.out.println();
        }
        
        System.out.println("---------------------------------------------------");
        System.out.println("a b c d e f g h i j k l m n o p q r s t u v w x y z");
    }
}
public class Lab13 {

    public static void main(String[] args) {
        Histogram hist = new Histogram();
        Scanner in = new Scanner(System.in);
        Scanner txt = new Scanner(System.in); 
            //had to use another scanner for my menu to work properly
        String res = "";
        do{
            System.out.println("      Menu");
            System.out.println("----------------");
            System.out.println("T: Enter A Text");
            System.out.println("P: Plot Frequencies");
            System.out.println("Q: Quit");
            res = in.next().toLowerCase();
            
            switch(res.charAt(0)){
                case 't':
                    System.out.println("Enter your text: ");
                    String S = txt.nextLine();
                    hist.setText(S);
                    break;
                case 'p':
                    hist.drawHistogram();
                    break;
                case 'q':
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid Option!");
                    break;
            }
        }while(res.charAt(0)!= 'q');
    }   
}
