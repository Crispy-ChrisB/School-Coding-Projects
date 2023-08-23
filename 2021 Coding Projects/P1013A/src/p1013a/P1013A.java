package p1013a;
class LoopExample {
    
    void printFormat() {
        int n = 123;
        double d = -123456.6789;
        String s = "Eku Students";
        
        System.out.println("123456789012345678901234567890123456789");
        System.out.printf("%5d %12.2f %12s \n",n,d,s);
        System.out.printf("%-5d %-12.2f %-12s \n",n,d,s);
    }
    // Print balance for n years
    void printBalance(double dep, double rate, int n) {
        double balance = dep;
        for (int y=1;y<=n;y++) {
            balance = balance+balance*rate/100;
            System.out.printf("Year %-2d: %8.2f",y,balance);
            System.out.println();
        }
    }
    
    // reverse string, if s = "abcd", return "dcba"
    String reverse(String s) {
        String r = "";
        
        for (int i = s.length()-1;i>=0; i--)
            r = r + s.charAt(i);
        
        return r;
    }
    
    // plot a rectangle of size n
    // when n = 5
    // *****
    // *****
    // *****
    // *****
    // *****
    void plotRect(int n) {
        for (int i=1;i<=n;i++){
         
            for (int j=1;j<=n;j++)
                System.out.print("*");
            
            System.out.println();
            
        }
    }
    
    // plot a triangle of size n
    // when n = 5
    // *
    // **
    // ***
    // ****
    // *****
    void plotTri1(int n) {
        for (int i=1;i<=n;i++){
         
            for (int j=1;j<=i;j++)
                System.out.print("*");
            
            System.out.println();
            
        }
    }
    
    // plot a Triangle of size n
    // when n = 5
    //     *
    //    **
    //   ***
    //  ****
    // *****
    void plotTri2(int n) {
        for (int i=1;i<=n;i++){
         
            for (int j=1;j<=n-i;j++)
                System.out.print(" ");
            
            for (int j=1;j<=i;j++)
                System.out.print("*");
            
            System.out.println();
            
        }
    }
    
    // plot a Triangle of size n
    // when n = 5
    //     *
    //    ***
    //   *****
    //  *******
    // ********* 
        void plotTri3(int n) {
        for (int i=1;i<=n;i++){
         
            for (int j=1;j<=n-i;j++)
                System.out.print(" ");
            
            for (int j=1;j<=2*i-1;j++)
                System.out.print("*");
            
            System.out.println();
            
        }
    }
        
         
/*    
    if n = 5, plotTri4(n) should plot

              1
           1  2  1
        1  2  4  2  1
     1  2  4  8  4  2  1  
  1  2  4  8 16  8  4  2  1
*/
    void plotTri4(int n) {
        for (int i=1;i<=n;i++) {
            
            for (int j=1;j<=n-i;j++)
                System.out.printf("%4s"," ");
            
            int k = 1;
            for (int j=1;j<=i;j++) {
                System.out.printf("%4d",k);
                k *= 2;
            }
            
            k /= 4;
            
            for (int j=1;j<i;j++) {
                System.out.printf("%4d",k);
                k /= 2;
            }
            
            System.out.println();            
        }
    }

    
}

public class P1013A {

    public static void main(String[] args) {
        // TODO code application logic here
        LoopExample lpEx = new LoopExample();
        
        lpEx.printFormat();
        lpEx.printBalance(1000, 5, 10);
        System.out.println(lpEx.reverse("abcddssdffe"));
        lpEx.plotRect(6);
        lpEx.plotTri1(7);
        lpEx.plotTri2(8);
        lpEx.plotTri3(6);
        lpEx.plotTri4(7);
    }
    
} 