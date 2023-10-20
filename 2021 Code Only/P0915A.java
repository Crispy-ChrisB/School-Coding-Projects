//How to choose a better way to write boolean expressions

package p0915a;
import java.util.*;
public class P0915A {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        double score;
        
        char grade = 'A';
        System.out.println("Enter your score 0-100");
        score = in.nextDouble();
        /*
        if (score > 100 || score < 0 )
            System.out.println("Please enter a score between 0-100.");
        else {
            if(score <= 100 && score >= 90) grade = 'A';
            if(score < 90 && score >= 70) grade = 'B';
            if(score < 70 && score >= 60) grade = 'C';
            if(score < 60 && score >= 51) grade = 'D';
            if(score < 51) grade = 'F';
        }
        */
        
        /*
        if(score >= 90) grade = 'A';
        else if(score >= 80) grade = 'B';
        else if(score >= 70) grade = 'C';
        else if(score >= 60) grade = 'D';
        else grade = 'F';
        */
        
        switch ((int)(score/10)){
            case 10:
            case 9:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            case 6:
                grade = 'D';
                break;
            case 5:
                grade = 'F';
                break;
            default:
                grade = 'F';
        }
        System.out.println("Your score is "+score+" which is a(n) "+grade+".");
         
    }
}
