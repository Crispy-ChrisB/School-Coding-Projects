//purpose: reverse a 5 digit integer
package p0108c;
import java.util.*;
public class P0108C {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n, r;
        System.out.println("Enter a 5 digit integer:");
        n = in.nextInt();
        
        //if 12345 is entered
        r = n/10000;          //r = 1
        r = r+10*(n/1000%10); //r = 21
        r = r+100*(n/100%10); //r = 321
        r = r+1000*(n/10%10); //r = 4321
        r = r+10000*(n%10);   //r = 54321
        
        System.out.println(n+" in reverse is "+r);
    }
    
}
