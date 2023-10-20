//
package p0920b;
import java.util.*;
public class P0920b {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x1, y1, x2, y2, px, py;
        System.out.println("Enter coordinates of the rectangle (x1, y1) and (x2, y2): ");
        x1 = in.nextDouble();
        y1 = in.nextDouble();
        x2 = in.nextDouble();
        y2 = in.nextDouble();
        System.out.println("Enter coordinates of the point (px, py): ");
        px = in.nextDouble();
        py = in.nextDouble();
        
        if ((px>x2 || px<x1) || (py<y2 || py>y1))
            System.out.println("The point ("+px+", "+py+") is outside the rectangle.");
        else if ((px>x1 && px<x2) && (py<y1 && py>y2))
            System.out.println("The point ("+px+", "+py+") is inside the rectangle.");
        
    }
    
}
