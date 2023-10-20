// course: CSC189
// project: Lab06
// date: Sept. 24, 2021
// author: Chris Ball
// purpose: Calculate how many days there are in a given month of a given year.
package lab06;
import java.util.*;
public class Lab06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int days = 0, month, year;
        String monthName = "";
        System.out.println("Enter a month in the year (e.g., 1 for Jan):");
        month = in.nextInt();
        System.out.println("Enter a year:");
        year = in.nextInt();
        
        if (month >= 1 && month <= 12){
            switch(month){
                case 1:
                    days = 31;
                    monthName = "January";
                    break;
                case 2:
                    if ((year%400 == 0) || ((year%4 == 0) && (year%100 != 0)))
                        days = 29;
                    else
                        days = 28;
                    monthName = "February";
                    break;
                case 3:
                    days = 31;
                    monthName = "March";
                    break;
                case 4:
                    days = 30;
                    monthName = "April";
                    break;
                case 5:
                    days = 31;
                    monthName = "May";
                    break;
                case 6:
                    days = 30;
                    monthName = "June";
                    break;
                case 7:
                    days = 31;
                    monthName = "July";
                    break;
                case 8:
                    days = 31;
                    monthName = "August";
                    break;
                case 9:
                    days = 30;
                    monthName = "September";
                    break;
                case 10:
                    days = 31;
                    monthName = "October";
                    break;
                case 11:
                    days = 30;
                    monthName = "November";
                    break;
                case 12:
                    days = 31;
                    monthName = "December";
                    break;
            }
            System.out.println(monthName+" "+year+" has "+days+" days");
        }
        else System.out.println("Not a valid month.");
        
    }
    
}
