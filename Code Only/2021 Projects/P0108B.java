//purpose: subtraction quiz
package p0108b;
import java.util.*;
public class P0108B {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //create 2 random single digit integers
        int number1 = (int) (Math.random()*10);
        int number2 = (int) (Math.random()*10);
        
        //if n1 < n2, swap numbers
        if (number1 < number2){
            int temp = number1;
            number1 = number2;
            number2 = temp;
        }
        
        //input from student to answer n1 - n2
        System.out.println("What is "+number1+" - "+number2+"?");
        int answer = in.nextInt();
        //if answer then display
        if (number1 - number2 == answer)
            System.out.println("You are correct!");
        else{
            System.out.println("Your answer is incorrect.");
            System.out.println("The answer should be "+(number1 - number2)+".");
        }
    }
    
}
