/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author christopher_ball37
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String str = "csc190 is not that hard!";
        System.out.println(str.indexOf("0"));
        System.out.println(str.charAt(str.length()-1));
        System.out.println(Math.pow(-2, -3));
        
        char grade = 'F';
        String comment;
        switch (grade){
            case 'A':
            case 'B':
            case 'C':
                comment = "passed";
                break;
            default:
                comment = "failed";
        }
        System.out.println(comment);
        
        int n = 5;
        if ((int)Math.sqrt(n) == Math.sqrt(n))
            System.out.println("Perfect Square");
        else
            System.out.println("Not");
    }
    
}
