/*
course: CSC210
project: Lab 03
date: Feb. 11th, 2022
author: Chris Ball
purpose: Create a triangle with given properties
 */
package lab03;
import java.util.Scanner;

class Triangle extends GeometricObject {
    double s1, s2, s3;
    
    Triangle() {
        s1 = 0;
        s2 = 0;
        s3 = 0;
    }
    
    void setSides(double s1, double s2, double s3){
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }
    
    void listTriangle(){
        System.out.println("Triangle: side1 = "+s1+" side2 = "+s2+" side3 = "+s3);
        System.out.println("The area: "+getArea());
        System.out.println("The perimeter: "+getPerimeter());
        System.out.println("Color: "+getColor());
        System.out.println("Filled: "+isFilled());
    }

    @Override
    public double getArea() {
        double p = getPerimeter()/2;
        return Math.sqrt(p*(p-s1)*(p-s2)*(p-s3));
    }

    @Override
    public double getPerimeter() {
        return (s1+s2+s3);
    }
}

public class Lab03 {

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter three sides: ");
        triangle.setSides(in.nextDouble(), in.nextDouble(), in.nextDouble());
        
        System.out.print("Enter the color: ");
        triangle.setColor(in.next());
        
        System.out.print("Enter a boolean value for filled: ");
        triangle.setFilled(in.nextBoolean());
        
        triangle.listTriangle();
        String res;
        do{
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.println("1: Enter new sides");
            System.out.println("2: Enter new color");
            System.out.println("3: Enter new filled value");
            System.out.println("4: List triangle");
            System.out.println("q: Quit");
            res = in.next();
            switch(res.charAt(0)){
                case '1':
                    System.out.print("Enter three sides: ");
                    triangle.setSides(in.nextDouble(), in.nextDouble(), in.nextDouble());
                    break;
                case '2':
                    System.out.print("Enter the color: ");
                    triangle.setColor(in.next());
                    break;
                case '3':
                    System.out.print("Enter a boolean value for filled: ");
                    triangle.setFilled(in.nextBoolean());
                    break;
                case '4':
                    triangle.listTriangle();
                    break;
                case 'q':
                case 'Q':
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Not an option");
            }
        }while(res.toLowerCase().charAt(0) != 'q');
    }
    
}

//-----GeometricObject Class--------
abstract class GeometricObject {
  private String color = "white";
  private boolean filled;
  private java.util.Date dateCreated;

  /** Construct a default geometric object */
  protected GeometricObject() {
    dateCreated = new java.util.Date();
  }

  /** Construct a geometric object with color and filled value */
  protected GeometricObject(String color, boolean filled) {
    dateCreated = new java.util.Date();
    this.color = color;
    this.filled = filled;
  }

  /** Return color */
  public String getColor() {
    return color;
  }

  /** Set a new color */
  public void setColor(String color) {
    this.color = color;
  }

  /** Return filled. Since filled is boolean,
   *  the get method is named isFilled */
  public boolean isFilled() {
    return filled;
  }

  /** Set a new filled */
  public void setFilled(boolean filled) {
    this.filled = filled;
  }

  /** Get dateCreated */
  public java.util.Date getDateCreated() {
    return dateCreated;
  }

  @Override
  public String toString() {
    return "created on " + dateCreated + "\ncolor: " + color +
      " and filled: " + filled;
  }

  /** Abstract method getArea */
  public abstract double getArea();

  /** Abstract method getPerimeter */
  public abstract double getPerimeter();
}