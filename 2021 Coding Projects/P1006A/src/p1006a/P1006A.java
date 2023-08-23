package p1006a;

class Loops{
    void print(){
        int i;
        for(i=1;i<=100;i++)
            System.out.println(i+": I like Java programming.");
    }
    //calculate 1+2+...+n
    long add(long n){
        long i, sum=0;
        for(i=1;i<=n;i++)
            sum = sum+1;
        return sum;
    }
    //calculate 1^2+2^2+3^2+...+n^2
    double add2(long n){
        long i;
        double sum = 0;
        for(i=1;i<=n;i++)
            sum += i^2;
        return sum;
    }
    //calculate 1+1/2+1/3+1/4+1/5+...+1/n
    double add3(long n){
        long i;
        double sum = 0;
        for(i=1;i<=n;i++)
            sum += 1.0/i;
        return sum;
    }
    //calculate 
    void add4(long n){
        long i;
        int cnt = 0;
        for(i=1;i<=n;i++){
            cnt++;
            n=n/2;
            System.out.println(i+" "+n);
        }
        System.out.println(cnt);
        System.out.println(i);
    }
    
    void count(){
        int cnt = 0;
        int i;
        for(i=0;i<=100;i++)
            cnt++;
        System.out.println(cnt+" "+i);//101 101
        
        cnt = 0;
        for(i=10;i<=100;i++)
            cnt++;
        System.out.println(cnt+" "+i);//91 101
        
        cnt = 0;
        for(i=100;i<=100;i++)
            cnt++;
        System.out.println(cnt+" "+i);//1 101
        
        cnt = 0;
        for(i=101;i<=100;i++)
            cnt++;
        System.out.println(cnt+" "+i);//0 101
        
        cnt = 0;
        for(i=100;i>=0;i--)
            cnt++;
        System.out.println(cnt+" "+i);//101 -1
        
        cnt = 0;
        i = 0;
        for(;i<=20;){
            cnt++;
            i++;
        }
        System.out.println(cnt+" "+i);//21 21
        
        cnt = 0;
        i=0;
        for(; ;){
            cnt++;
            i++;
            if(i==20)
                break;
        }
        System.out.println(cnt+" "+i);//20 20
        
        cnt = 0;
        int j=0;
        for(i=1;i<=10;i++){ //outer loop
            for(j=1;j<=10;j++)//inner loop
                cnt++;
        }
        System.out.println(cnt+" "+i+" "+j);//100 11 11
        
        cnt = 0;
        j=0;
        int k=0;
        for(i=1;i<=10;i++){ //outer loop
            for(j=1;j<=10;j++){//inner loop
                for(k=1;k<=10;k++)
                cnt++;
            }
        }
        System.out.println(cnt+" "+i+" "+j+" "+k);//1000 11 11 11
        
        cnt = 0;
        for(i=1;i<=10;i++);
            cnt++;
        System.out.println(cnt+" "+i);//1 11
    }
    
}

public class P1006A {
    public static void main(String[] args) {
        Loops mylp = new Loops();
        //mylp.print();
        System.out.println(mylp.add(10000));
        System.out.println(mylp.add2(10000));
        System.out.println(mylp.add3(10000));
        mylp.add4(10);
        mylp.count();
    }
    
}
