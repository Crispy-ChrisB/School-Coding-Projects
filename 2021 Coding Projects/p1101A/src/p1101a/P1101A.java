//calculate greatest common divisor
//(a,b) -> (b,a%b) repeatedly until (d,0) d = greatest common divisor
package p1101a;
import java.util.*;

public class P1101A {
//greatest common divisor of 2 numbers
    //gcd (105,60) = 3*5=15, 105 = 3*5*7, 60 = 2*2*3*5
    //gcd (105,60) = (60,45) = (45,15) = (15,0)
    static int gcd(int n1, int n2) {
        while(n2>0){
            int i=n1%n2;
            n1=n2;
            n2=i;
        }
        return n1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;
        do {
            System.out.println("Enter n1: ");
            int n1 = in.nextInt();
            System.out.println("Enter n2: ");
            int n2 = in.nextInt();
            
            System.out.println("gcd("+n1+","+n2+") = "+gcd(n1,n2));
            
            System.out.print("To continue? y or n: ");
            res=in.next();
        }while(res.toLowerCase().charAt(0) == 'y');
    //post condition
    System.out.println("Thank you for using this program!");
    
    }
}