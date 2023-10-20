//methods practice
//calculate the weighted average
//homework: 200 (25%)
//lab: 240 (15%)
//quiz: 100 (15%)
//test1: 100 (10%)
//test2: 100 (15%)
//test3: 100 (20%)
package p1004b;
import java.util.*;
public class P1004B {
    static double weightedAverage(double hw, double lab, double q, double test1, double test2, double test3){
        double weightedScore;
        weightedScore = (hw/200)*25 + (lab/240)*15 + (q/100)*15 + (test1/100)*10 + (test2/100)*15 + (test3/100)*20;
        return weightedScore;
        
    }
    static char getGrade(double score){
        char grade;
        switch ((int) (score/10)){
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
            default:
                grade = 'F';
        }
        return grade;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double hw, lab, quiz, test1, test2, test3;
        
        System.out.println("Enter your homework score(0-200): ");
        hw = in.nextDouble();
        System.out.println("Enter your lab score(0-240): ");
        lab = in.nextDouble();
        System.out.println("Enter your quiz score(0-100): ");
        quiz = in.nextDouble();
        System.out.println("Enter your test 1 score(0-100): ");
        test1 = in.nextDouble();
        System.out.println("Enter your test 2 score(0-100): ");
        test2 = in.nextDouble();
        System.out.println("Enter your test 3 score(0-100): ");
        test3 = in.nextDouble();
        
        double weightedScore;
        weightedScore = weightedAverage(hw, lab, quiz, test1, test2, test3);
        char grade = getGrade(weightedScore);
        System.out.println("Your weighted score is "+weightedScore+" which is a(n) "+grade+".");
    }
    
}
