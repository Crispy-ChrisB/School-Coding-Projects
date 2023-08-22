package basiccalculator;
import java.util.Scanner;
public class BasicCalculator {

    public static void main(String[] args) {
        Scanner word = new Scanner(System.in);
        Scanner number = new Scanner(System.in);
        System.out.println("Very Basic Calculator");
        System.out.println("Enter your operation:");
        System.out.println("+ = Add");
        System.out.println("- = Subtract");
        System.out.println("* = Multiply");
        System.out.println("/ = Divide");
        System.out.println("^ = Exponent");
        System.out.println("! = Square Root");
        System.out.println("& = Absolute Value");
        String operation = word.next();
        
        System.out.println("Enter your first number:");
        double num1 = number.nextDouble();
        System.out.println("Enter your second number:");
        double num2 = number.nextDouble();

        if ("+".equalsIgnoreCase(operation)){
        System.out.println("The sum of "+num1+" + "+" "+num2+" is "+(num1+num2));
        }
        if ("-".equalsIgnoreCase(operation)){
        System.out.println("The difference of "+num1+" - "+" "+num2+" is "+(num1-num2));
        }
        if ("*".equalsIgnoreCase(operation)){
        System.out.println("The product of "+num1+" * "+" "+num2+" is "+(num1*num2));
        }
        if ("/".equalsIgnoreCase(operation)){
        System.out.println("The quotient of "+num1+" / "+" "+num2+" is "+(num1/num2));
        }
        if ("^".equalsIgnoreCase(operation)){
        System.out.println("The value of "+num1+" to the power of "+" "+num2+" is "+(Math.pow(num1,num2)));
        }
        if ("!".equalsIgnoreCase(operation)){
        System.out.println("The Square Root of "+num1+" and the Square Root of "+num2+" is "+(Math.sqrt(num1))+" and "+(Math.sqrt(num2)));
        }
        if ("&".equalsIgnoreCase(operation)){
        System.out.println("The Absolute Value of "+num1+" and the Absolute Value of "+num2+" is "+(Math.abs(num1))+" and "+(Math.abs(num2)));
        }
    }
}
