/*
course: CSC210
project: Hw 05
date: March 3rd, 2022
author: Chris Ball
purpose: A program that lists the top 5
            boy and girl baby names from 2001 - 2010 
            and saves them in a .txt file
*/
package hw05;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class Hw05 {
    static void topFiveNames() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the directory path");
        String dirpath = in.nextLine();
        File topNames = new File(dirpath);
        java.io.PrintWriter writeTo = new java.io.PrintWriter(topNames+"/topFiveBabyNames.txt");
        
        writeTo.write("---------------------------------------------------------"
                + "--------------------------------------------------------------\n");
        writeTo.write("Year  Rank1  Rank2  Rank3  Rank4  "
                    + "Rank5  Rank1  Rank2  Rank3  Rank4  Rank5\n");
        writeTo.write("----------------------------------------------------"
                    + "-------------------------------------------------------------------\n");
        
        //File babyNamesTxts = new File(dirpath+"/babynamesranking2001"+".txt");
        //Scanner reader = new Scanner(babyNamesTxts);
        String male, female;
        for(int i=2001;i<=2010;i++){
            File babyNamesTxts = new File(dirpath+"/babynamesranking"+i+".txt");
            Scanner reader = new Scanner(babyNamesTxts);
            
            writeTo.write(i+"  ");
            for(int j=1;j<=5;j++){
                String data = reader.nextLine();
                writeTo.write(data + "\n");
            }
            writeTo.close();
        }
        
    } 
    
    static void searchRanking() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the directory");
        String dirpath = in.nextLine();
        System.out.print("Enter a name: ");
        String name = in.nextLine();
        int year;
        do{
            System.out.print("Enter a year between 2001-2010: ");
            year = in.nextInt();
        }while(year < 2001 || year > 2010);
        
        File babyNamesTxts = new File(dirpath+"/babynamesranking"+year+".txt");
        Scanner reader = new Scanner(babyNamesTxts);
        
        for(int i=1;i<=1000;i++){
            if(reader.findInLine(name) != null){
                System.out.println("The name "+name+" is ranked #"+i+
                        " in the year "+year+".");
                break;
            }
            else if(reader.findInLine(name) == null){
                if(i == 1000)
                    System.out.println("The name "+name+" is not ranked.");
                else {} 
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String res;
        do{
            System.out.println("a. Generate a file containing top five names");
            System.out.println("b. Search a name ranking in a specific year");
            System.out.println("q. quit");
            System.out.print("Select: ");
            res = in.next().toLowerCase();
            switch(res.charAt(0)){
                case 'a':
                    topFiveNames();
                    break;
                case 'b':
                    searchRanking();
                    break;
                case 'q':
                    break;
                default:
                    System.out.println("Not an option");
            }
        }while(res.charAt(0) != 'q');
    }
}


//I couldn't get the topFiveName() method and the searchRanking()
//method kept giving me an error and saying access denied.