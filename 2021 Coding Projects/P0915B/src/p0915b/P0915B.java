//sorting
package p0915b;
import java.util.*;
public class P0915B {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n1, n2, n3, n4;
        
        System.out.println("Enter 4 numbers:");
        n1 = in.nextInt();
        n2 = in.nextInt();
        n3 = in.nextInt();
        n4 = in.nextInt();
        
        int temp;
        //pass 1
        if(n1>n2){
            temp = n1;
            n1 = n2;
            n2 = temp;
        }
        if(n2>n3){
            temp = n2;
            n2 = n3;
            n3 = temp;
        }
        if(n3>n4){
            temp = n3;
            n3 = n4;
            n4 = temp;
        }
        //pass 2
        if(n1>n2){
            temp = n1;
            n1 = n2;
            n2 = temp;
        }
        if(n2>n3){
            temp = n2;
            n2 = n3;
            n3 = temp;
        }
        //pass 3
        if(n1>n2){
            temp = n1;
            n1 = n2;
            n2 = temp;
        }
        System.out.println(""+n1+n2+n3+n4);
    }
    
}
