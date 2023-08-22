package p1020a;
class Loops {
    int count(String s){
        int cnt = 0;
        for(int i=0;i<s.length();i++)
            cnt++;
        return cnt;
    }
    int countChar(String s, char c){
        int cnt = 0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)==c)
                cnt++;
        return cnt;
    }
    //remove all duplicate characters from string s
    String removeDup(String s){
        String r = "";
        for(int i=0;i<s.length();i++)
            if(r.indexOf(s.charAt(i))==-1)
                r+=s.charAt(i);
        return r;
    }
    //Check if a string is a palindrome
    boolean isPalin(String s){
        int n = s.length();
        for(int i=0;i<n/2;i++)
            if(s.charAt(i)!=s.charAt(n-1-i))
                return false;
        return true;
    }
    //Check if an integer is a prime number
    boolean isPrime(int n){
        for(int i=2;i<=n-1;i++)
            if(n%i==0)
                return false;
        return true;
    }
    boolean isPrime1(int n){
        for(int i=2;i<=n-1;i++)
            if(n%i!=0) continue;
            else return false;
        return true;
    }
    boolean isPrime2(int n){
        int i;
        for(i=2;i<=n-1;i++)
            if(n%i!=0) continue;
            else break;
        if(i==n)
            return true;
        else return false;
    }
    //find the nth fibonacci number
    long getFib(int n){
        long f1=1, f2=1, f3=2;
        if(n<3) return 1;
        for(int i=3;i<=n;i++){
            f3=f1+f2;
            f1=f2;
            f2=f3;
        }
        return f3;
    }
    //find char mode
    char mode(String s){
        char maxCh = ' ';
        int maxCnt = 0;
        
        for(int i=0;i<s.length();i++){
            int cnt=0;
            for(int j=i;j<s.length();j++)
                if(s.charAt(i)==s.charAt(j))
                    cnt++;
            if(cnt>maxCnt){
                maxCnt = cnt;
                maxCh = s.charAt(i);
            }
        }
        return maxCh;
    }
    String printStr(String s){
        String r = "";
        int len = s.length();
        for(int i=0;i<len;i++)
            for(int j=0;j<len-i;j++)
                r = r+s.substring(j, i+j+1)+", ";
        return r;
    }
}
public class P1020A {
    public static void main(String[] args) {
        Loops lp = new Loops();
        System.out.println(lp.count("abcdefg"));
        System.out.println(lp.countChar("abbbccdddefg",'b'));
        System.out.println(lp.removeDup("abbbccdddefg"));
        System.out.println(lp.isPalin("abcdcba"));
        System.out.println(lp.isPalin("abcdfcba"));
        System.out.println(lp.isPrime(25));
        System.out.println(lp.isPrime(11));
        System.out.println(lp.isPrime1(25));
        System.out.println(lp.isPrime1(11));
        System.out.println(lp.isPrime2(25));
        System.out.println(lp.isPrime2(11));
        System.out.println(lp.getFib(10));
        System.out.println(lp.mode("abbbacacbab"));
        System.out.println(lp.printStr("abcdef"));
    }
    
}
