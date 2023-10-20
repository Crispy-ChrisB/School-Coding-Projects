/*
purpose: numeric data types
 */
package p0901a;

public class P0901a {


    public static void main(String[] args) {
        int n;
        long n1;
        float f;
        double d;
        
        n = 217483649;
        System.out.println(n);
        //n = n+1;  //n++
        n++;
        System.out.println(n);
        n1 = 217483647L;
        System.out.println(n1);
        d = 3.141592653538910101010;
        System.out.println(d);
        f = 3.141592653538910101010f;
        System.out.println(f);
        d = f;
        System.out.println(d);
        f = (float)d;
        System.out.println(f);
    }
    
}
