//pass by value vs. pass by reference

package p1110b;
public class P1110B {
    static void modify(int n){
        n = 20;
    }
    static void modify(String s){
        s="modified";
    }
    static void modify(int a[], int n){
        for(int i=0;i<n;i++)
            a[i] = i+1;
    }
    public static void main(String[] args) {
        int r = 1;
        modify(r);
        System.out.println(r);
        
        String str = "original";
        modify(str);
        System.out.println(str);
        
        int[] A = {0,2,0,10,0,0};
        for(int i=0;i<6;i++)
            System.out.print(A[i]+" ");
        System.out.println();
        modify(A, 6);
        for(int i=0;i<6;i++)
            System.out.print(A[i]+" ");
        System.out.println();
    }
    
}
