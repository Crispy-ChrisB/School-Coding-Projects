/*
course: CSC210
project: Hw 09
date: April 14th, 2022
author: Chris Ball
purpose: Display information from a text file
*/
package hw09;
import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class Hw09 {
    public static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value){
        Set<T> keys = new HashSet<T>();
        for(Entry<T, E> entry : map.entrySet()) 
            if (Objects.equals(value, entry.getValue()))
                keys.add(entry.getKey());
        
        return keys;
    }
    public static void inquire(int year, File file) throws FileNotFoundException{
        Map<Integer, String> boys = new TreeMap<>();
        Map<Integer, String> girls = new TreeMap<>();
        Scanner sc = new Scanner(file);
        int key = 1;
        try{
            while(sc.hasNext()){
                for(int i = 1;i<6;i++){
                    if(i%2 == 0){
                        if(i==2)
                            boys.put(key, sc.next());
                        if(i==4)
                            girls.put(key, sc.next());
                    }
                else
                        sc.next();
                    if(i==5){
                        i=0;
                        key++;
                    }
                }
            }
        }catch(Exception NoSuchElementException){}
        
        Set<String> boyValues = new TreeSet<>(boys.values());
        Set<String> girlValues = new TreeSet<>(girls.values());
        
        for(String boy: boyValues){
            if(girlValues.contains(boy))
                System.out.println(boy+": boy"+getKeysByValue(boys, boy)+" girl"+getKeysByValue(girls, boy));
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Directory for babynamesrankings: ");
        String dir = in.nextLine();
        
        String res;
        do{
                System.out.print("Enter the year: ");
                int year = in.nextInt();
                File file = new File(dir+"/babynamesranking"+year+".txt");
            
                try{
                    inquire(year, file);
                }catch(Exception FileNotFound){
                    System.out.println("File Not Found");
                }
            
            System.out.println("... \nEnter another inquiry? y/n");
            res = in.next();
        }while(res.toLowerCase().charAt(0) != 'n');
        System.out.println("Thanks for using my program!");
    }   
}