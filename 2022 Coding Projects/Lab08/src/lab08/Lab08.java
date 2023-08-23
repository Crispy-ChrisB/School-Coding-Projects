/*
course: CSC210
project: Lab 08
date: April 1st, 2022
author: Chris Ball
purpose: A program that reports the letter with the most occurrences
*/
package lab08;
import java.util.*;

public class Lab08 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a line of text:");
        String text = in.nextLine().toLowerCase();
        
        HashMap<Character, Integer> map = new HashMap<>();
        char[] tokens = text.toCharArray();
        for(Character key: tokens)
            if(key >= 'a' && key <= 'z')
                map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
        
        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        
        entries.sort((entry1, entry2) ->    
         entry1.getValue().compareTo(entry2.getValue()) == 0 ?
         entry1.getKey().compareTo(entry2.getKey()) :
         entry1.getValue().compareTo(entry2.getValue()));
        Collections.reverse(entries);
        
        System.out.println("The following letter(s) occurred most ["+entries.get(0).getValue()+" times]:");
        for(int i=0; i<entries.size();i++){
            if(entries.size() == 1){
                System.out.println(entries.get(i).getKey());
                break;
            }
            else if(entries.get(i).getValue().compareTo(entries.get(i+1).getValue()) == 0){
                System.out.print(entries.get(i).getKey()+" ");
            }
            else{
                System.out.print(entries.get(i).getKey()+"\n");
                break;
            }
        }
    }
}