/*
course: CSC210
project: Lab 04
date: Feb. 18th, 2022
author: Chris Ball
purpose: 
*/
package lab04;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab04 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a file's path and name");
        var File = in.next();
        var name = in.next();
        java.io.File file = new java.io.File(File, name);
        if(name == "" || name == " ")
            System.out.println("Usage: "+File+" file");
        if(file.exists() == false){
            System.out.println("Source file "+name+" does not exist");
            System.out.println("Usage: C:/Users/(username)/...");
        }
        if(file.exists()){
            BufferedReader reader = null;
            int charCount = 0;
            int wordCount = 0;
            int lineCount = 0;
            
            try{
                reader = new BufferedReader(new FileReader(file));
                String currentLine = reader.readLine();
                while(currentLine != null){
                    lineCount++;
                    String[] words = currentLine.split(" ");
                    wordCount += words.length;
                    for(String word : words)
                        charCount += word.length();
                    currentLine = reader.readLine();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Lab04.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Lab04.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("File "+name+" has");
            System.out.println(charCount+" characters");
            System.out.println(wordCount+" words");
            System.out.println(lineCount+" lines");
        }
    }
    
}
