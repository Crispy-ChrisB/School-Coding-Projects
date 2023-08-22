//binary numbers
package p1027b;
import java.util.*;
class Binary {
    //convert decimal number to binary
    String dToB(int n){
        String b = "";
        while(n>0){
            b = n%2 + b;
            n = n/2;
        }
        return b;
    }
    
    //convert binary to decimal
    int bToD(String b){
        int n = 0;
        for(int i=0;i<b.length();i++)
            n = n*2 + b.charAt(i)-'0';
        return n;
    }
    
    //add 2 binary numbers
    //c = 11111110
    //b1 = 1101101
    //b2 =   10111
    //-------------
    //b = 10000100
    String addB(String b1, String b2){
        String b = "";
        int len1 = b1.length()-1;
        int len2 = b2.length()-1;
        int c = 0;
        while(len1>=0 && len2>=0){
            int s = b1.charAt(len1)-'0'+b2.charAt(len2)-'0'+c;
            b = s%2 + b;
            c = s/2;
            len1--;
            len2--;
        }
        while(len1>=0){
            int s = b1.charAt(len1)-'0'+c;
            b = s%2 + b;
            c = s/2;
            len1--;
        }
        while(len2>=0){
            int s = b2.charAt(len2)-'0'+c;
            b = s%2 + b;
            c = s/2;
            len2--;
        }
        if(c == 1)
            b = c+b;
        return b;
    }
    //mulitply two binary numbers
    String multiplyB(String b1, String b2){
        String b = "";
        String pad = "";
        for(int i=b2.length()-1;i>=0;i--){
            if(b2.charAt(i) == '1')
                b = addB(b, b1+pad);
            pad+="0";
        }
        return b;
    }
}
public class P1027B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Binary myB = new Binary();
        int n;
        String res, b, b1, b2;
        
        do{
            System.out.println("1: Decimal to Binary");
            System.out.println("2: Binary to Decimal");
            System.out.println("3: Add Binaries");
            System.out.println("4: Multiply Binaries");
            System.out.println("q: Quit");
            
            res = in.next();
            switch(res.charAt(0)){
                case '1':
                    System.out.print("Enter an integer: ");
                    n = in.nextInt();
                    System.out.println(myB.dToB(n));
                    break;
                case '2':
                    System.out.print("Enter a binary: ");
                    b = in.next();
                    System.out.println(myB.bToD(b));
                    break;
                case '3':
                    System.out.print("Enter binary 1: ");
                    b1 = in.next();
                    System.out.print("Enter binary 2: ");
                    b2 = in.next();
                    System.out.println(myB.addB(b1, b2));
                    break;
                case '4':
                    System.out.print("Enter binary 1: ");
                    b1 = in.next();
                    System.out.print("Enter binary 2: ");
                    b2 = in.next();
                    System.out.println(myB.multiplyB(b1, b2));
                    break;
                case 'q':
                case 'Q':
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid Option");
            }
            
        }while(res.charAt(0) != 'q' && res.charAt(0) != 'Q');
    }
    
}