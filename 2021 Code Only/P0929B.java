package p0929b;
public class P0929B {
    
    public static void main(String[] args) {
        System.out.println("The grade is: ");
        printGrade(94);
        
        System.out.println("The grade is: ");
        printGrade(74);
        
        System.out.println("The grade is: ");
        printGrade(34);
    }
    
    public static void printGrade(double score){
        if(score >= 90) System.out.println("A");
        else if(score >= 80) System.out.println("B");
        else if(score >= 70) System.out.println("C");
        else if(score >= 60) System.out.println("D");
        else System.out.println("F");
    }
            
    
}
