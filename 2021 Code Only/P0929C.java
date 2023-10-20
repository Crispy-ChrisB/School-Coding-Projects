package p0929c;
public class P0929C {
    
    public static void main(String[] args) {
        System.out.println("The grade is: "+returnGrade(94));
        System.out.println("The grade is: "+returnGrade(79));
        System.out.println("The grade is: "+returnGrade(39));
    }
    
    public static char returnGrade(double score){
        char letterGrade;
        if(score >= 90) letterGrade = 'A';
        else if(score >= 80) letterGrade = 'B';
        else if(score >= 70) letterGrade = 'C';
        else if(score >= 60) letterGrade = 'D';
        else letterGrade = 'F';
        return letterGrade;
    }
            
    
}
