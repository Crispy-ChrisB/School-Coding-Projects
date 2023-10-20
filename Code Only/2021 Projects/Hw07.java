/*
course: CSC189
project: Hw 07
date: Oct. 13, 2021
author: Chris Ball
purpose: Determine the area and perimeter of equilateral and equiangular regular polygons
*/
package hw07;
class RegularPolygon {
    int n = 3;
    double side = 1;
    double x = 0;
    double y = 0;
    final double PI = 3.14159;
    
    //Constructors
    RegularPolygon(){
        n = 3;
        side = 1;
        x = 0;
        y = 0;
    }
    
    RegularPolygon(int sides, double sideLength){
        n = sides;
        side = sideLength;
    }
    
    RegularPolygon(int sides, double sideLength, double xCoord, double yCoord){
        n = sides;
        side = sideLength;
        x = xCoord;
        y = yCoord;
    }
    
    //Mutators
    void setSide(int sides){
        n = sides;
    }
    void setSideLength(double sideLength){
        side = sideLength;
    }
    void setX(double xCoord){
        x = xCoord;
    }
    void setY(double yCoord){
        y = yCoord;
    }
    
    //Getters
    double getPerimeter(){
        return n*side;
    }
    double getArea(){
        //Calculated for degrees
        return (n*side*side)/((4*Math.tan(PI/n))*(3.14159/180));
    }
    
}
public class Hw07 {
    public static void main(String[] args) {
        RegularPolygon reg1 = new RegularPolygon();
        RegularPolygon reg2 = new RegularPolygon(6,4);
        RegularPolygon reg3 = new RegularPolygon(10,4,5.6,7.8);
        System.out.println("Reg1's Perimeter is: "+reg1.getPerimeter());
        System.out.println("Reg1's Area is: "+reg1.getArea());
        System.out.println("Reg2's Perimeter is: "+reg2.getPerimeter());
        System.out.println("Reg2's Area is: "+reg2.getArea());
        System.out.println("Reg3's Perimeter is: "+reg3.getPerimeter());
        System.out.println("Reg3's Area is: "+reg3.getArea());
        //I am unsure what the x,y was for. 
    }
}
