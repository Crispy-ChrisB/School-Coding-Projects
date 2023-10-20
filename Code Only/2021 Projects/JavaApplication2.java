/*
course: csc189
project: practiceWeek3
date: Aug.30, 2021
author: Chris Ball
purpose: to practice
 */
package javaapplication2;

public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char letter = 'A';
        char letter02 = '\u03b7';
        String name = " Chris ";
        System.out.println(letter);
        System.out.println(++letter);
        System.out.println(letter02);
        System.out.println("Next line"+"\n"+letter02);
        System.out.println(name.length());
        System.out.println(name.charAt(3));
        System.out.println(name);
        name = name.trim();
        System.out.println(name.length());
        System.out.println(name.charAt(3));
        System.out.println(name);
        String name2 = " Ball";
        String fullname = name.concat(name2);
        System.out.println(fullname);
        System.out.println(fullname.indexOf("a"));
        
        
    }
}
