/*
course: CSC210
project: Hw 04
date: Feb. 22th, 2022
author: Chris Ball
purpose: A program that acts as a student record
*/
package hw04;
import java.util.Scanner;

interface SortInterface {
    static void sortGPA(StudentRecord v[], int n){
        int length = n;
        
        for(int i = 0; i<=length; length--){
            for(int j = 1; j<=length; j++,i++){
                if(v[i].getGPA() > v[j].getGPA()){
                    StudentRecord temp = v[i];
                    v[i] = v[j];
                    v[j] = temp;
                }
                i = 0;
            }
        }
    }
}
class Sort implements SortInterface {
    
    void sortGPA(StudentRecord v[], int n){}
    public int SearchGPA(StudentRecord v[], int n, double gpa) {
        for(int i=0;i<=n;){
            if((double) v[i].getGPA() == (double) gpa)
                return i;
            
            else
                i++;
        }
        return -1;
    }
}

class StudentRecord {

    private String name; // student’s name
    private int EarnedCh; // Earned credit hours
    private int QualPts; // Total quality points
    private double GPA; // GPA = (double)QualPts/ EarnedCh

    public StudentRecord() {
        name = "";
        EarnedCh = 0;
        QualPts = 0;
        GPA = 0.0;
    }
    public StudentRecord(String nm, int Eh, int QPts) {
        name = nm;
        EarnedCh = Eh;
        QualPts = QPts;
        GPA = (double) (QualPts/EarnedCh);
    }

    public String getName() {
        return name;
    }

    public int getEarnedCh() {
        return EarnedCh;
    }
    
    public int getQualPts() {
        return QualPts;
    }
    
    public double getGPA() {
        return GPA;
    }

    public void setName(String nm) {
        name = nm;
    }
    
    public void setEarnedCh(int Eh) {
        EarnedCh = Eh;
        GPA = (double) (QualPts/EarnedCh);
    }
    
    public void setQualPts(int QPts) {
        QualPts = QPts;
        GPA = (double) (QualPts/EarnedCh);
    }
}

public class Hw04 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StudentRecord[] stuRec = new StudentRecord[100]; 
        
        
        //stuRec[0].setName("jim");
        System.out.println(stuRec.length);
        
        int i=0;
        String res = "y";
        do{
            switch(res.toLowerCase().charAt(0)){
                case 'y': 
                    
                    for(int j=i; j<100; j++){
                        StudentRecord stuRecPlaceHolder = new StudentRecord();
                        System.out.print("Student's Name: ");
                        stuRecPlaceHolder.setName(in.next()+" "+in.next());
                        System.out.print("Student's Credit Hours: ");
                        stuRecPlaceHolder.setEarnedCh(in.nextInt());
                        System.out.print("Student's Quality Points: ");
                        stuRecPlaceHolder.setQualPts(in.nextInt());
                        stuRec[i] = stuRecPlaceHolder;
                        i++;
                        break;
                    }
                    break;
                case 'n':
                    break;
                default:
                    System.out.println("Not an option");
            }
            System.out.println("Enter another student? Y/N");
            res = in.next();
        }while(res.toLowerCase().charAt(0) != 'n');
        
        SortInterface.sortGPA(stuRec,i-1);
        System.out.println("Item#   Name         CreditHours   "
                + "QualityPoints   GPA");
        for(int j = 0; j<i; j++){
            System.out.printf("%-7s %s %3s %13s %16s",j,stuRec[j].getName(),
                    stuRec[j].getEarnedCh(),stuRec[j].getQualPts(),stuRec[j].getGPA());
            System.out.println();
        }
        
        System.out.print("Enter a GPA: ");
        double GPA = in.nextDouble();
        
            Sort sort = new Sort();
            int k = sort.SearchGPA(stuRec, i-1, GPA);
            if(k != -1)
                System.out.println("Found a record: \nName: "
                        +stuRec[k].getName()+"  Credit Hours: "
                        +stuRec[k].getEarnedCh()+"  Quality Points: "
                        +stuRec[k].getQualPts()+"  GPA: "+stuRec[k].getGPA());
            if(sort.SearchGPA(stuRec, i-1, GPA) == -1)
                System.out.println("No matched record!");   
    }
}