//solve quadratic equations
package p0920d;
import java.util.*;
public class P0920d {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a, b, c;
        
        System.out.println("Enter a.");
        a = in.nextDouble();
        System.out.println("Enter b.");
        b = in.nextDouble();
        System.out.println("Enter c.");
        c = in.nextDouble();
        
        if (a==0){
            if (b==0)
                System.out.println("Invalid equation.");
            else
                System.out.println("Linear equation: x = "+ (-c/b));
        }
        else {
            double d = b*b - 4*a*c;
            if (d>0){
                System.out.println("Two roots: ");
                System.out.println("x1 = "+((-b+Math.sqrt(d))/(2*a)));
                System.out.println("x2 = "+((-b-Math.sqrt(d))/(2*a)));
            }
            else if (d==0){
                System.out.println("One root: ");
                System.out.println("x = "+(-b/(2*a)));
            }
            else System.out.println("No real solutions.");
        }       
    }   
}