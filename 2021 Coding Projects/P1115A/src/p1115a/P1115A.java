package p1115a;

import java.util.*;
class myArray {
    final int MAXSIZE = 20; //maximum size
    int A[]; //define an array
    int n; //actual size of array
    
    myArray(){
        A = new int[MAXSIZE];
        n=0;
    }
    
    void readA(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a positive integer (-1 to stop): ");
        int num = in.nextInt();
        n=0;
        while(num>0){
            A[n++]=num;
            if(n==MAXSIZE){
                System.out.println("Array is full");
                break;
            }
            System.out.print("Enter a positive integer (-1 to stop): ");
            num = in.nextInt();
        }
    }
    
    void generateA(){
        Random rd = new Random();
        n = rd.nextInt(MAXSIZE)+1;
        
        for(int i=0;i<n;i++)
            A[i]=rd.nextInt(100);
    }
    
    void printA(){
        for(int i=0;i<n;i++)
            System.out.print(A[i]+" ");
        System.out.println();
    }
    
    int maxA(){
        int max = A[0];
        for(int i=1;i<n;i++)
            if(max<A[i])
                max = A[i];
        return max;
    }
    
    void reverseA(){
        for(int i=0;i<n/2;i++){
            int tmp = A[i];
            A[i] = A[n-1-i];
            A[n-1-i] = tmp;
        }
    }
    
    void rotateAL(){
        int tmp = A[0];
        for(int i=1;i<n;i++)
            A[i-1] = A[i];
        A[n-1]=tmp;
    }
    
    void rotateAR(){
        int tmp = A[n-1];
        for(int i=n-2;i>=0;i--)
            A[i+1]=A[i];
        A[0]=tmp;
    }
    
    void bubbleA(){
        for(int i=0;i<n-1;i++)
            for(int j=0;j<n-1-i;j++)
                if(A[j]>A[j+1]){
                    int tmp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = tmp;
                }
    }
    
    void bubble2A(){
        for(int i=0;i<n-1;i++){
            boolean exchange = false;
            for(int j=0;j<n-1-i;j++)
                if(A[j]>A[j+1]){
                    int tmp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = tmp;
                    exchange = true;
                }
            if(exchange == false)
                break;
        }
    }
    
    void insertionA(){
        for(int i=1;i<=n-1;i++){
            int j = i;
            while(j>0 && A[j-1]>A[j]){
                int tmp = A[j];
                A[j] = A[j-1];
                A[j-1] = tmp;
                j--;
            }
        }
    }
    
    void insertion2A(){
        for(int i=1;i<=n-1;i++){
            int j = i;
            int t = A[j];
            while(j>0 && t<A[j-1]){
                A[j] = A[j-1];
                j--;
            }
            A[j]=t;
        }
    }
    
    int isSorted(){
        if(A[0]<=A[1]){
            for(int i=1;i<n-1;i++)
                if(A[i]>A[i+1])
                    return 0;
            return 1;
        }
        else{
            for(int i=1;i<n-1;i++)
                if(A[i]<A[i+1])
                    return 0;
            return 2;
        }
    }
    int sequential(int key){
        for(int i=0;i<n;i++)
            if(key==A[i])
                return i;
        return -1;
    }
    int binarySearch(int key){
        int left = 0;
        int right = n-1;
        
        while(left<=right){
            int mid = (left+right)/2;
            if(A[mid]>key)
                right = mid-1;
            else if(A[mid]<key)
                left = mid+1;
            else return mid;
        }
        return -1;
    }
}
public class P1115A {

    public static void main(String[] args) {
        myArray myA = new myArray();
        Scanner in = new Scanner(System.in);
        String res;
        do{
            System.out.println("Select: ");
            System.out.println("1: Read");
            System.out.println("2: Generate");
            System.out.println("3: Print");
            System.out.println("4: Find Max Number");
            System.out.println("5: Reverse the Array");
            System.out.println("6: Rotate Array Left");
            System.out.println("7: Rotate Array Right");
            System.out.println("8: Bubble Sort");
            System.out.println("9: Insertion Sort");
            System.out.println("a: Sorted?");
            System.out.println("b: Sequential Search");
            System.out.println("c: Binary Search");
            System.out.println("q: Quit");
            
            res = in.next();
            switch(res.charAt(0)){
                case '1':
                    myA.readA();
                    break;
                case '2':
                    myA.generateA();
                    break;
                case '3':
                    myA.printA();
                    break;
                case '4':
                    System.out.println("The max value in the array is "+myA.maxA());
                    break;
                case '5':
                    myA.reverseA();
                    break;
                case '6':
                    myA.rotateAL();
                    break;
                case '7':
                    myA.rotateAR();
                    break;
                case '8':
                    myA.bubbleA();
                    break;
//                case '9':
//                    myA.bubble2A();
//                    break;
                case '9':
                    myA.insertion2A();
                    break;
                case 'a':
                    if(myA.isSorted()==1)
                        System.out.println("Sorted in ascending order.");
                    else if(myA.isSorted()==2)
                        System.out.println("Sorted in descending order.");
                    else System.out.println("Not Sorted");
                    break;
                case 'b':
                    System.out.print("Enter a key to search: ");
                    int key = in.nextInt();
                    int index = myA.sequential(key);
                    if(index == -1)
                        System.out.println(key+" is not found in the array.");
                    else 
                        System.out.println(key+" is found in the array with index "+index+".");
                    break;
                case 'c':
                    System.out.print("Enter a key to search: ");
                    key = in.nextInt();
                    if(myA.isSorted() == 1){
                        index = myA.binarySearch(key);
                        if(index == -1)
                        System.out.println(key+" is not found in the array.");
                    else 
                        System.out.println(key+" is found in the array with index "+index+".");
                    }else
                        System.out.println("The array must be in ascending order for binary search.");
                    break;
                case 'q': 
                case 'Q':
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid input");
            }
            
        }while(res.charAt(0)!='q' && res.charAt(0)!='Q');
    }
}
