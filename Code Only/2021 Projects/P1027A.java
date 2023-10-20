package p1027a;
public class P1027A {
    public static void main(String[] args) {
        int i = 0;
        int sum = 0;
        while(i<=10){
            sum += i;
            i++;
        }
        System.out.println("The sum of 0 to 10 is "+sum);
        
        i = 0;
        sum = 0;
        for(i=0;i<=10;i++)
            sum += i;
        System.out.println("The sum of 0 to 10 is "+sum);
    
    i = 0;
    sum = 0;
    do{
        sum += i;
        i++;
    }while(i<=10);
    System.out.println("The sum of 0 to 10 is "+sum);
    }
    
    
}
