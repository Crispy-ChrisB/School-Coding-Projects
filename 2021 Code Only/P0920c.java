
package p0920c;
import java.util.*;
public class P0920c {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        double c1x, c1y, r1, c2x, c2y, r2;
        System.out.println("Enter the coordinate of the center point of circle 1: ");
        c1x = in.nextDouble();
        c1y = in.nextDouble();
        System.out.println("Enter the radius of circle 1: ");
        r1 = in.nextDouble();
        
        System.out.println("Enter the coordinate of the center point of circle 2: ");
        c2x = in.nextDouble();
        c2y = in.nextDouble();
        System.out.println("Enter the radius of circle 2: ");
        r2 = in.nextDouble();
        
        double d = Math.sqrt((c1x - c2x)*(c1x - c2x) + (c1y - c2y)*(c1y - c2y));
        
        if (d>(r1+r2))
            System.out.println("The two circles disjoint.");
        else if ((d+r1) <= r2)
            System.out.println("Circle 1 is inside circle 2.");
        else if ((d+r2) <= r1)
            System.out.println("Circle 2 is inside circle 1.");
        else
            System.out.println("The two circles overlap.");
    }
    
}
