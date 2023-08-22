//arrays
package p1110a;

public class P1110A {

    public static void main(String[] args) {
        int[] n = new int[10];
        
        n[0] = 20;
        n[1] = 100;
        
        System.out.println(n[0]);
        System.out.println(n[1]);
        
        for(int i = 0; i<n.length;i++)
            System.out.println(n[i]);
        
        boolean b[] = new boolean[20];
        b[10] = true;
        for(int i = 0; i<20; i++)
            System.out.println(b[i]+" ");
    }
    
}
