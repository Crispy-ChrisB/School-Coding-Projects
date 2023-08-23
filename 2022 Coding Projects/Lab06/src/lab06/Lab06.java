/*
course: CSC210
project: Lab 06
date: March 11th, 2022
author: Chris Ball
Purpose: Check a java source code file for correct pairing of grouping symbols
*/
package lab06;
import java.util.*;
import java.io.*;

public class Lab06 {

    public static void check(File java) throws FileNotFoundException{
        Scanner read = new Scanner(java);
        
        List<String> symbols = new ArrayList<>(); 
        int i=0;
        
        while(read.hasNext()){
            if(read.hasNext("("))
                symbols.set(i, "(");
            if(read.hasNext("{"))
                symbols.set(i, "{");
            if(read.hasNext("["))
                symbols.set(i, "[");
            if(read.hasNext(")"))
                symbols.set(i, ")");
            if(read.hasNext("}"))
                symbols.set(i, "}");
            if(read.hasNext("]"))
                symbols.set(i, "]");
            i++;
        }
        for(int j=0;j<symbols.size();j++){
            switch(symbols.get(j)){
                case "(":
                    for(int k=j+1;k<symbols.size();k++){
                        if(symbols.get(k) == ")")
                            continue;
                        else if(symbols.get(k) == "}" || symbols.get(k) == "]"){
                            System.out.println("Illegal pairing of group symbols");
                            break;
                        }
                    }
                    break;
                case "{":
                    for(int k=j+1;k<symbols.size();k++){
                        if(symbols.get(k) == "}")
                            continue;
                        else if(symbols.get(k) == ")" || symbols.get(k) == "]"){
                            System.out.println("Illegal pairing of group symbols");
                            break;
                        }
                    }
                    break;
                case "[":
                    for(int k=j+1;k<symbols.size();k++){
                        if(symbols.get(k) == "]")
                            continue;
                        else if(symbols.get(k) == "}" || symbols.get(k) == ")"){
                            System.out.println("Illegal pairing of group symbols");
                            break;
                        }
                    }
                    break;
                default:
            }
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the directory of a Java file to check: ");
        File java = new File(in.nextLine());
        //System.out.println(java);
        if(java.canRead())
            check(java);
        else
            System.out.println("This file cannot be read.");
    }
    
}
