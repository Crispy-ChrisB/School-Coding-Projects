/*
course: CSC210
project: Hw01
date: Jan. 27, 2022
author: Chris Ball
purpose: A program that imitates an ATM
*/
package hw01;
import java.time.Instant;
import java.util.*;
class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    
    Account(){
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        dateCreated = Date.from(Instant.now());
    }
    
    Account(int specifiedId, double initialBalance){
        id = specifiedId;
        balance = initialBalance;
        dateCreated = Date.from(Instant.now());
    }
    
    void setId(int x){
        id = x;
    }
    
    void setBalance(double x){
        balance = x;
    }
    
    void setAnnualInterestRate(double x){
        annualInterestRate = x;
    }
    
    int getId(){
        return id;
    }
    
    double getBalance(){
        return balance;
    }
    
    double getAnnualInterestRate(){
        return annualInterestRate;
    }
    
    Date getDateCreated(){
        return dateCreated;
    }
    
    double getMonthlyInterestRate(){
        return annualInterestRate/12;
    }
    
    double getMonthlyInterest(){
        return balance*getMonthlyInterestRate();
    }
    
    void withdraw(int accountID, double amount){
        balance -= amount;
    }
    
    void deposit(int accountID, double amount){
        balance += amount;
    }
    
    
    
}

public class Hw01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Account ATM = new Account();
        double[] accounts = new double[10];
        
        for(int i=0;i!=accounts.length-1;i++)
            accounts[i] = 100;
        
        ATM.setAnnualInterestRate(.045);
        
        System.out.print("Enter an id: ");
        int id = in.nextInt();
        
        if(id<0 || id>9){
            do{
                System.out.println("Incorrect ID. Please enter a correct ID.");
                id = in.nextInt();
            }while(id<0 || id>9);
        }
        
        System.out.println();
        
        String res;
        do{
            System.out.println("Main menu");
            System.out.println("1: check balance");
            System.out.println("2: withdraw");
            System.out.println("3: deposit");
            System.out.println("4: print summary");
            System.out.println("5: exit");
            System.out.print("Enter a choice: ");
            res = in.next();
            switch(res.charAt(0)){
                case '1':
                    System.out.println("The balance is "+accounts[id]);
                    System.out.println();
                    break;
                case '2':
                    System.out.print("Enter an amount to withdraw: ");
                    accounts[id] -= in.nextDouble();
                    System.out.println();
                    break;
                case '3':
                    System.out.print("Enter an amount to deposit: ");
                    double x = in.nextDouble();
                    if(x<0)
                        System.out.println("The amount is negative, ignored.");
                    else
                        accounts[id] += x;
                    System.out.println();
                    break;
                case '4':
                    System.out.println("Account ID is "+id);
                    System.out.println("Balance is "+accounts[id]);
                    System.out.println("Monthly interest is "+(accounts[id]*ATM.getMonthlyInterestRate()));
                    System.out.println("This account was created at "+ATM.getDateCreated());
                    System.out.println();
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
