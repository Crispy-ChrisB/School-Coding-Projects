//rational number calculations
// -4/-2 = 2,   1/2 + 1/3
package p1101b;
import java.util.*;
class Rational {
    private int num,den;
    
    Rational(){
    }
    
    Rational(int n, int d){
        int f = gcd(Math.abs(n), Math.abs(d));
        num = n/f;
        den = d/f;
        
        if(den<0){
            num *= -1;
            den *= -1;
        }
    }
    
    void setRational(int n, int d){
        int f = gcd(Math.abs(n), Math.abs(d));
        num = n/f;
        den = d/f;
        
        if(den<0){
            num *= -1;
            den *= -1;
        }
    }
    
    int gcd(int n1, int n2){
        while(n2>0){
            int r=n1%n2;
            n1=n2;
            n2=r;
        }
        return n1;
    }
    
    Rational addR(Rational r1, Rational r2){
        return new Rational(r1.num*r2.den+r2.num*r1.den,
        r1.den*r2.den);
    }
    
    Rational subR(Rational r1, Rational r2){
        return new Rational(r1.num*r2.den-r2.num*r1.den,
        r1.den*r2.den);
    }
    
    Rational multR(Rational r1, Rational r2){
        return new Rational(r1.num*r2.num, r1.den+r2.den);
    }
    
    Rational divR(Rational r1, Rational r2){
        return new Rational(r1.num*r2.den, r1.den+r2.num);
    }
    
    void readR(){
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter numerator: ");
        int num = in.nextInt();
        System.out.print("Enter denominator: ");
        int den = in.nextInt();
        while(den==0){
            System.out.print("Enter denominator (not zero): ");
            den = in.nextInt();
        }
        setRational(num, den);
    }
    
    void printR(){
        if(den==1)
            System.out.print(num);
        else
            System.out.print(num+"/"+den);
    }
}
public class P1101B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Rational r1 = new Rational();
        Rational r2 = new Rational();
        
        String res;
        do{
            System.out.println("a. add rational");
            System.out.println("s. subtract rational");
            System.out.println("m. mulitply rational");
            System.out.println("d. divide rational");
            System.out.println("q. quit");
            
            System.out.print("Select: ");
            res = in.next();
            
            switch(res.toLowerCase().charAt(0)){
                case 'a':
                    r1.readR();
                    r2.readR();
                    r1.addR(r1, r2).printR();
                    System.out.println();
                    break;
                case 's':
                    r1.readR();
                    r2.readR();
                    r1.subR(r1, r2).printR();
                    System.out.println();
                    break;
                case 'm':
                    r1.readR();
                    r2.readR();
                    r1.multR(r1, r2).printR();
                    System.out.println();
                    break;
                case 'd':
                    r1.readR();
                    r2.readR();
                    r1.divR(r1, r2).printR();
                    System.out.println();
                    break;
                case 'q':
                    System.out.println("Goodbye!");
                    break;
                //case default:
                  //System.out.println("Invalid! Try Again.");
            }
            
        }while(res.toLowerCase().charAt(0) != 'q');
    }
    
}
