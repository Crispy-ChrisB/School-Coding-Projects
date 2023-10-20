/*
Purpose: understand loops better
Create a calendar
 */
package p1018a;

class Calendar {
    int leap(int year){
        if ((year%4) != 0)
            return 0;
        else if (year%100 != 0)
            return 1;
        else if(year%400 == 0)
            return 1;
        else return 0;
    }
    
    int getNumberDays(int year, int month){
        switch (month){
            case 2: return 28+leap(year);
            case 4:
            case 6:
            case 9:
            case 11: return 30;
            default: return 31;
        }
    }
    
    int getTotalDays(int year, int month){
        int total = 0;
        
        for(int i = 1900; i<year; i++) //calculate total days from 1900 to year-1
            total += 365+leap(i);
        for(int i=1; i<month; i++) //add days from current month-1
            total += getNumberDays(year, i);
        return total;
    }
    String getNameOfMonth(int month){
        switch (month){
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            default: return "December";
        }
    }
    
    void printCal(int year, int month){
        System.out.println(" "+getNameOfMonth(month)+" "+year);
        System.out.println(" Su Mo Tu We Th Fr Sa");
        int days = getTotalDays(year, month);
        int dw = (days+1)%7;
        for(int i=1;i<=dw;i++)
            System.out.printf("%3s", " ");
        int cnt = dw;
        for (int i=1; i<= getNumberDays(year, month); i++){
            System.out.printf("%3d", i);
            cnt++;
            if(cnt%7 == 0)
                System.out.println();
        }
        System.out.println();
    }
    
}
public class P1018A {
    public static void main(String[] args) {
        Calendar mycal = new Calendar();
        mycal.printCal(2021, 10);
    }
    
}
