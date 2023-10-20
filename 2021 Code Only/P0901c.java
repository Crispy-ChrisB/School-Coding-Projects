package p0901c;
/*
Purpose: time addition and subtraction
 */
import java.util.*;
public class P0901c {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h1, m1, s1, h2, m2, s2;
        
        int h, m, s;
        
        System.out.println("Enter time 1: ");
        h1 = in.nextInt();
        m1 = in.nextInt();
        s1 = in.nextInt();
        
        System.out.println("Enter time 2: ");
        h2 = in.nextInt();
        m2 = in.nextInt();
        s2 = in.nextInt();
        
        s = (s1 + s2)%60;
        m = ((m1 + m2)+(s1+s2)/60)%60;
        h = (h1+h2+((m1+m2)/60)+s1+s2/360)%24;
        
        System.out.println(h1+" hour(s), "+m1+" minute(s), and "+s1+" second(s) + "
                +h2+" hour(s), "+m2+" minute(s), and "+s2+" second(s) is "+h+" hour(s), "+m+" minute(s), and "+s+" second(s)");
        
        
        //subtraction
        s = (60+s1 - s2)%60;
        m = (60+m1-m2-(s1+s2)/60)%60;
        h = h1-h2-(m1+m2)/60;
                
        System.out.println("Time 1 - Time 2 = "+h+" hours, "+m+" minutes, and "+s+" seconds.");
    }
    
}
