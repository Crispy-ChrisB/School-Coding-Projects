package p0929d;
//has the 
public class P0929D {
    public static void main(String[] args) {
        int x = 1;
        System.out.println("Before the call: x = "+x);
        x = increment(x);
        System.out.println("After the call: x = "+x);
        
    }
    public static int increment(int n){
        n++;
        return n;
    }
    
}
