// course: CSC189
// project: Lab04
// date: Sept. 10, 2021
// author: Chris Ball
// purpose: Encrypt a 5-digit integer
package lab04;
import java.util.*;
public class Lab04 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter a 5-digit integer to encrypt:");
        int n, r;
        n = in.nextInt();
        
        n = (((13 - (n/10000))%10)*10000)+(((13 - (n/1000%10))%10)*1000)+(((13 - (n/100%10))%10)*100)+(((13 - (n/10%10))%10)*10)+(((13 - (n%10))%10));
        r = n/10000;
        r = r+10*(n/1000%10);
        r = r+100*(n/100%10);
        r = r+1000*(n/10%10);
        r = r+10000*(n%10);
        System.out.println(r);
    }
    
}