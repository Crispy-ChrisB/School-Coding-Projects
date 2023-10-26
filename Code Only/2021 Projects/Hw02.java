/*
 course: CSC189
 project: Hw 02
 date: 
 author: Christopher Ball
 purpose: This program reads a length in (km, m, cm, mm) and 
        converts it to (miles, yards, feet, inches)
 */
package hw02;
import java.util.*;
public class Hw02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int km, m, cm, mm; //input variables
        int miles, yards, feet, inches; //output variables
 
        System.out.print("Enter kilometer part of input:");
        km = in.nextInt();
        System.out.print("Enter meter part of input:");
        m = in.nextInt();
        System.out.print("Enter centimeter part of input:");
        cm = in.nextInt();
        System.out.print("Enter millimeter part of input:");
        mm = in.nextInt();
 
        //steps for computing miles, yards, feet, inches go here
        double totalMm = km*1000000+m*1000+cm*10+mm; //Converts everything to mm for ease of access
        double totalIn = totalMm/25.4; //Converts the mm to in.
        miles = (int) (totalIn/63360); //Calculates how many miles in the total inches.
        totalIn = (totalIn%63360); //Gets rid of the inches used for miles.
        yards = (int) (totalIn/36); //Calculates how many yards in the remaining inches.
        totalIn = (totalIn%36); //Gets rid of the inches used for yards.
        feet = (int) (totalIn/12); //Calculates how many feet in the remaining inches.
        totalIn = (totalIn%12); //Gets rid of the inches used for feet.
        inches = (int) (totalIn);

        System.out.println("(" + km + " km, " + m + " m, " + cm + " cm, " + mm + " mm) = "
                + "(" + miles + " miles, " + yards + " yards, " + feet
                + " feet, " + inches + " inches)");
    }
}
