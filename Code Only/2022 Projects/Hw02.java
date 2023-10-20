/*
course: CSC210
project: Hw 02
date: Feb. 3rd, 2022
author: Chris Ball
purpose: Make a stopwatch that counts (in milliseconds) 
    how long it takes to sort 100,000 integers in different ways
*/
package hw02;

import java.util.*;

class StopWatch {
    private Long startTime;
    private Long endTime;
    
    Long getStartTime(){
        return startTime;
    }
    Long getEndTime(){
        return endTime;
    }
    
    StopWatch(){
        startTime = System.currentTimeMillis();
    }
    
    void start(){
        startTime = System.currentTimeMillis();
    }
    void stop(){
        endTime = System.currentTimeMillis();
    }
    long getElapsedTime(){
        return endTime - startTime;
    }
}

class generate {
    int[] random = new int[100000];
    
    void generate(){
        for(int i=0;i<random.length;i++)
            random[i] = (int) (Math.random()*100000);
    }
}

class BubbleSort extends generate{
    void sort(){
        int length = random.length;
        for(int i=0;i<length;length--){
            for(int j=1;j<length;j++,i++)
                if(random[i]>random[j]){
                    int temp = random[i];
                    random[i] = random[j];
                    random[j] = temp;
                }
            i=0;
        }
    }
    
    void list(){
        for(int i=0;i<random.length;i++)
            System.out.println(random[i]);
    }
}

class SelectionSort extends generate{
    void sort(){
        int temp, hold=-1;
        for(int i=0;i<random.length;i++){
            temp = random[i];
            for(int j=i+1;j<random.length;j++)
                if(random[j]<temp){
                    temp = random[j];
                    hold = j;
                }
            random[hold] = random[i];
            random[i] = temp;
        }
    }
    
    void list(){
        for(int i=0;i<random.length;i++)
            System.out.println(random[i]);
    }
}

class InsertionSort extends generate{
    void sort(){
        for(int i=1;i<random.length;i++){
            int temp = random[i], j = i-1;
            while(j>=0 && random[j]>temp){
                random[j+1] = random[j];
                j = j-1;
            }
            random[j+1] = temp;
        }
    }
    
    void list(){
        for(int i=0;i<random.length;i++)
            System.out.println(random[i]);
    }
}

public class Hw02 {

    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        BubbleSort bubble = new BubbleSort();
        SelectionSort selection = new SelectionSort();
        InsertionSort insertion = new InsertionSort();
        Scanner in = new Scanner(System.in);
        
        
        String res;
        do{
            System.out.println("Main menu");
            System.out.println("1: Generate and Time Bubble Sorting");
            System.out.println("2: Generate and Time Selection Sorting");
            System.out.println("3: Generate and Time Insertion Sorting");
            System.out.println("a: Bubble Sort List (WILL LIST 100,000 NUMBERS)");
            System.out.println("b: Selection Sort List (WILL LIST 100,000 NUMBERS)");
            System.out.println("c: Insertion Sort List (WILL LIST 100,000 NUMBERS)");
            System.out.println("5: exit");
            System.out.print("Enter a choice: ");
            
            res = in.next();
            switch(res.charAt(0)){
                case '1':
                    bubble.generate();
                    watch.start();
                    bubble.sort();
                    watch.stop();
                    System.out.println("That took "+watch.getElapsedTime()+
                            " milliseconds to bubble sort.");
                    break;
                case '2':
                    selection.generate();
                    watch.start();
                    selection.sort();
                    watch.stop();
                    System.out.println("That took "+watch.getElapsedTime()+
                            " milliseconds to selection sort.");
                    break;
                case '3':
                    insertion.generate();
                    watch.start();
                    insertion.sort();
                    watch.stop();
                    System.out.println("That took "+watch.getElapsedTime()+
                            " milliseconds to insertion sort.");
                    break;
                case 'a':
                    bubble.list();
                    break;
                case 'b':
                    selection.list();
                    break;
                case 'c':
                    insertion.list();
                    break;
                case '5':
                    break;
                default:
                    System.out.println("That is not an option.");
                    System.out.println();
            }
        }while(res.charAt(0)!='5');
    }
}
