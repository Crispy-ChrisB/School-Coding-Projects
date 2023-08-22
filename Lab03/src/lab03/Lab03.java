// course: CSC189
// project: lab03
// date: Sept. 3, 2021
// author: Christopher Ball
// purpose: Print all of the 4! permutations of the 4 words in order.
package lab03;

import java.util.*;
public class Lab03 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter a 4 word sentence:");
        String sentence = in.nextLine();
        
        //gets the first word of the sentence
            String word1 = sentence.substring(0, (sentence.indexOf(" "))); 
        //gets the second word of the sentence
            String word2 = sentence.substring(sentence.indexOf(" ")+1, sentence.indexOf(" ", (sentence.indexOf(" ")+1)));
        //gets the third word of the sentence
            String word3 = sentence.substring(word1.length()+word2.length()+2,sentence.lastIndexOf(" "));
        //gets the fourth word of the sentence
            String word4 = sentence.substring(sentence.lastIndexOf(" ")+1);
        
    //Outputs every combination of the 4-word sentence
        System.out.println(word1+" "+word2+" "+word3+" "+word4);
        System.out.println(word1+" "+word2+" "+word4+" "+word3);
        System.out.println(word1+" "+word3+" "+word2+" "+word4);
        System.out.println(word1+" "+word3+" "+word4+" "+word2);
        System.out.println(word1+" "+word4+" "+word2+" "+word3);
        System.out.println(word1+" "+word4+" "+word3+" "+word2);
        System.out.println(word2+" "+word3+" "+word4+" "+word1);
        System.out.println(word2+" "+word3+" "+word1+" "+word4);
        System.out.println(word2+" "+word4+" "+word1+" "+word3);
        System.out.println(word2+" "+word4+" "+word3+" "+word1);
        System.out.println(word2+" "+word1+" "+word4+" "+word3);
        System.out.println(word2+" "+word1+" "+word3+" "+word4);
        System.out.println(word3+" "+word4+" "+word1+" "+word2);
        System.out.println(word3+" "+word4+" "+word2+" "+word1);
        System.out.println(word3+" "+word1+" "+word2+" "+word4);
        System.out.println(word3+" "+word1+" "+word4+" "+word2);
        System.out.println(word3+" "+word2+" "+word1+" "+word4);
        System.out.println(word3+" "+word2+" "+word4+" "+word1);
        System.out.println(word4+" "+word1+" "+word2+" "+word3);
        System.out.println(word4+" "+word1+" "+word3+" "+word2);
        System.out.println(word4+" "+word2+" "+word1+" "+word3);
        System.out.println(word4+" "+word2+" "+word3+" "+word1);
        System.out.println(word4+" "+word3+" "+word1+" "+word2);
        System.out.println(word4+" "+word3+" "+word2+" "+word1);
    //I know there is probably a better way to do this using if loops
        
    }
    
}
