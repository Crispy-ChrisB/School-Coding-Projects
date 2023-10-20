package p0929a;
public class P0929A {
    
    public static void main(String[] args) {
        int i = 5;
        int j = 2;
        int k = max(i, j);  //invoke max method
        System.out.println("The maximum between "+i+" and "+j+" is "+k+".");
    }
    
    //returns the maximum between 2 integers
    public static int max(int num1, int num2){
        int result;
        
        if (num1 > num2)
            result = num1;
        else 
            result = num2;
        return result;
    }
    
}
