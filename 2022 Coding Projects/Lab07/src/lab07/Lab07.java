/*
course: CSC210
project: Lab 07
date: March 25th, 2022
author: Chris Ball
Purpose: Program to find a directory size
*/
package lab07;
import java.io.File;
import java.util.*;

public class Lab07 {
    
    public static long getSize_Queue(File directory){
        long size = 0;
        Queue<File> queue = new LinkedList<>();
        queue.offer(directory);
        while(!queue.isEmpty()){
            File t = queue.poll();
            if(t.isFile())
                size += t.length();
            else{
                File[] file = t.listFiles();
                for(int i=0; file!=null && i<file.length;i++)
                    queue.offer(file[i]);
            }
        }
        return size;
    }
    
    public static long getSize_Stack(File directory){
        long size = 0;
        Stack<File> stack = new Stack();
        stack.push(directory);
        while(!stack.isEmpty()){
            File t = stack.pop();
            if(t.isFile())
                size += t.length();
            else{
                File[] file = t.listFiles();
                for(int i=0; file!=null && i<file.length;i++)
                    stack.push(file[i]);
            }
        }
        return size;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter a directory or a file: ");
        
        File directory = new File(in.nextLine());
        
        if(directory.isFile() || directory.isDirectory()){
            System.out.println(getSize_Queue(directory) + " bytes (Queue)");
            System.out.println(getSize_Stack(directory) + " bytes (Stack)");
        }
        else
            System.out.println("Not valid");
    }
}