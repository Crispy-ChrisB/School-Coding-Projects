package p0310a;
import java.util.Stack;

public class P0310A {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack();
        
        for(int i=0; i<10; i++)
            myStack.push(i);
        
        System.out.println(myStack.peek());
        System.out.println(myStack.search(4));        
        System.out.println(myStack.empty());        
        System.out.println(myStack.peek());        
        System.out.println(myStack.pop());        
        System.out.println(myStack.peek());        
        System.out.println(myStack.size());
    }
    
}
