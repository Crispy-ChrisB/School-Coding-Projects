//determine if it is a leap year (has 366 days)
//a leap year is divisible by 4
//a leap year is not divisible by 100
//a leap year is divisible by 400
package p0920a;
import java.util.*;
public class P0920a {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year;
        
        System.out.println("Enter a year:");
        year = in.nextInt();
        
        //METHOD 1
        if (year%4 == 0)
            if (year%100 == 0)
                if (year%400 == 0)
                    System.out.println(year+" is a leap year.");
                else
                    System.out.println(year+" is not a leap year.");
            else
                System.out.println(year+" is a leap year.");
        else
            System.out.println(year+" is not a leap year.");
        
        //METHOD 2
        if (year%4 != 0)
            System.out.println(year+" is not a leap year.");
        else if (year%100 != 0)
            System.out.println(year+" is a leap year.");
        else if (year%400 == 0)
            System.out.println(year+" is a leap year.");
        else
            System.out.println(year+" is not a leap year.");
        
        //METHOD 3
        if ((year%400 == 0) || ((year%4 == 0) && (year%100 != 0)))
                System.out.println(year+" is a leap year.");
        else
            System.out.println(year+" is not a leap year.");
    }
    
}
