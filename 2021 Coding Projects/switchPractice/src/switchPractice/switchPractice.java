package switchPractice;
import java.util.*;
public class switchPractice {


    public static void main(String[] args) {
        System.out.println(Math.pow(-2, -1));
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 0 or 1 for Status:");
        int status = input.nextInt();
        switch (status) {
            case 0: System.out.println("Status is 0");
                break;
            case 1: System.out.println("Status is 1");
                break;
            default: System.out.println("Error: Status is unavailable");
        }
        //------------------------------------
        int n1, n2, n3, n4;
        int max = 0;
        
        n1 = input.nextInt();
        n2 = input.nextInt();
        n3 = input.nextInt();
        n4 = input.nextInt();
        
        max = n1;
        if(n2>max) max = n2;
        if(n3>max) max = n3;
        if(n4>max) max = n4;
        System.out.println("The max is "+max);
        //------------------------------------
        
        
    }
    
}
