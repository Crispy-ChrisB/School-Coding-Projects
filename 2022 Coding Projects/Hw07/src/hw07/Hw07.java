/*
course: CSC210
project: Hw 07
date: March 24th, 2022
author: Chris Ball
purpose: Program to evaluate postfix expressions
*/
package hw07;
import java.util.Stack;
import java.util.Scanner;

public class Hw07 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your expression: ");
        try{
            System.out.println(evaluateExpression(in.nextLine()));
        }
        catch(Exception ex){
            System.out.println("Invalid expression");
        }
    }
    
    public static int evaluateExpression(String expression){
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        
        expression = insertBlanks(expression);
        String[] tokens = expression.split(" ");
        for(String token: tokens){
            if(token.length() == 0)
                continue;
            else if(token.charAt(0) == '+' || token.charAt(0) == '-'){
                while(!operatorStack.isEmpty() && (
                    operatorStack.peek() == '+' ||
                    operatorStack.peek() == '-' || 
                    operatorStack.peek() == '*' ||
                    operatorStack.peek() == '/')){
                        processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));
            }
            else if(token.charAt(0) == '*' || token.charAt(0) == '/'){
                while(!operatorStack.isEmpty() && (
                    operatorStack.peek() == '*' ||
                    operatorStack.peek() == '/')){
                        processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));
            }
            else if(token.trim().charAt(0) == '(')
                operatorStack.push('(');
            else if(token.trim().charAt(0) == ')'){
                while(operatorStack.peek() != '(')
                    processAnOperator(operandStack, operatorStack);
                operatorStack.pop();
            }
            else
                operandStack.push(Integer.valueOf(token));
        }
        
        while(!operatorStack.isEmpty())
            processAnOperator(operandStack, operatorStack);
        
        return operandStack.pop();
    }
    
    public static void processAnOperator(
        Stack<Integer> operandStack, Stack<Character> operatorStack) {
            char op = operatorStack.pop();
            int op1 = operandStack.pop();
            int op2 = operandStack.pop();
                
        switch (op) {
            case '+' -> operandStack.push(op2 + op1);
            case '-' -> operandStack.push(op2 - op1);
            case '*' -> operandStack.push(op2 * op1);
            case '/' -> operandStack.push(op2 / op1);
            default -> {
            }
        }
    }
    
    public static String insertBlanks(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(' || s.charAt(i) == ')'
                    || s.charAt(i) == '+' || s.charAt(i) == '-'
                    || s.charAt(i) == '*' || s.charAt(i) == '/') 
                result += " " + s.charAt(i) + " ";
            else 
                result += s.charAt(i);
        }

        return result;
    }
}