//while loop examples
package p1025a;
class WhileLoops {
    //add 1+2+3+...+n
    int sum1(int n){
        int sum=0;
        for(int i=1;i<=n;i++)
           sum+=i;
        return sum;
    }
    
    int sum2(int n){
        int sum=0;
        int i=1;
        while(i<=n){
            sum+=i;
            i++;
        }
        return sum;
    }
    
    //reverse integer n
    //n = 123456  return = 654321
    int reverse(int n){
        int r=0;
        while(n>0){
            r = r*10+n%10;
            n=n/10;
        }
        return r;
    }
    
    //add digits in an integer
    //n = 123456  return = 21 (1+2+3+4+5+6)
    int sumDigits(int n){
        int sum = 0;
        while(n > 0){
            sum += n%10;
            n = n/10;
        }
        return sum;
    }
    
    //Determine if an integer n is a power of 2
    boolean isPow(int n){
        if(n==1 || n==2) return true;
        while(n>1){
            /*
            if(n%2 != 0) return false;
            n=n/2;
            */
            //--------------------------------
            if (n%2==0)
                n=n/2;
            else return false;
        }
        return true;
    }
    
    //Check if an integer is a prime number
    boolean isPrime(int n){
        for(int i=2; i<n/2; i++)
            if(n%i == 0)
                return false;
        return true;
    }
    boolean isPrime1(int n){
        int i=2;
        while(i<n/2){
            if(n%i==0)
                return false;
            i++;
        }
        return true;
    }
    
    //find the largest prime number less than n
    //if n =100, return 97
    int getPrime(int n){
        int p = n-1;
        while(p>1){
            int k = 2;
            while(p%k != 0) //checks if p is prime number
                k++;
            if(p==k) //if true, p = prime
                break;
            else //if false, p != prime
                p--; //reduce p by 1 and check if it is a prime number in the next iteration
        }
        return p;
    }
    
    //find the largest 2's power less than n
    //if n = 100, return = 64
    int getPow(int n){
        int p = n-1;
        while(p>1){
            int k = p;
            while(k%2 == 0)
                k/=2; //k=k/2;
            if(k == 1) break;
            else p--;
        }
        return p;
    }
    int getPow1(int n){
        int p = 1;
        while(p<n)
            p=p*2;
        return p/2;
    }
    
    //find factors of integer n
    //if n =120, return = 2*2*2*3*5
    String factorize(int n){
        String f = "";
        int p = 2;
        while(n>1){
            while(n%p == 0){
                f = f+p+"*";
                n/=p;
            }
            p++;
        }
        return f.substring(0,f.length()-1);
    }
    
    //find factors of an integer n
    //if n = 120, return = 2^3*3*5
    String factorize1(int n){
        String f = "";
        int p = 2;
        int cnt = 0;
        while(n>1){
            while(n%p == 0){
                cnt++;
                n/=p;
            }
            if (cnt==1)
                f = f+p+"*";
            else if(cnt>1)
                f = f+p+"^"+cnt+"*";
            cnt=0;
            p++;
        }
        return f.substring(0,f.length()-1);
    }
}
public class P1025A {
    public static void main(String[] args) {
        WhileLoops w1 = new WhileLoops();
        System.out.println(w1.sum1(10));
        System.out.println(w1.sum2(10));
        System.out.println(w1.reverse(198534));
        System.out.println(w1.sumDigits(198534));
        System.out.println(w1.isPow(32));
        System.out.println(w1.isPrime(7));
        System.out.println(w1.isPrime1(7));
        System.out.println(w1.getPrime(100));
        System.out.println(w1.getPow(100));
        System.out.println(w1.getPow1(100));
        System.out.println(w1.factorize(120));
        System.out.println(w1.factorize1(120));
        
    }
    
}
