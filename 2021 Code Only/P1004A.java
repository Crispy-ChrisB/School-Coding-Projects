//define an instant class
package p1004a;
class Circle{
    double radius; //radius of the circle
    double cx, cy; //x, y coords of center point
    final double PI = 3.14159;
    
    //Constructor
    Circle(){
        cx = 0;
        cy = 0;
        radius = 0;
    }
    
    Circle(double x, double y, double r){
        cx = x;
        cy = y;
        radius = r;
    }
    
    //getters
    double getXcoordinate(){
        return cx;
    }
    double getYcoordinate(){
        return cy;
    }
    double getRadius(){
        return radius;
    }
    double getArea(){
        return PI*radius*radius;
    }
    double getCircum(){
        return 2*PI*radius;
    }
    
    //mutators
    void setXYcoordinates(double x, double y){
        cx = x;
        cy = y;
    }
    void setRadius(double r){
        radius = r;
    }
}

public class P1004A {
    public static void main(String[] args) {
        Circle cir1 = new Circle();
        Circle cir2 = new Circle(4, 5, 10);
        
        System.out.println(cir1.getXcoordinate());
        System.out.println(cir1.getYcoordinate());
        System.out.println(cir1.getRadius());
        System.out.println(cir1.getArea());
        System.out.println(cir1.getCircum());
        
        System.out.println(cir2.getXcoordinate());
        System.out.println(cir2.getYcoordinate());
        System.out.println(cir2.getRadius());
        System.out.println(cir2.getArea());
        System.out.println(cir2.getCircum());
        
        cir1.setXYcoordinates(2, 7);
        cir1.setRadius(6);
        System.out.println(cir1.getXcoordinate());
        System.out.println(cir1.getYcoordinate());
        System.out.println(cir1.getRadius());
        System.out.println(cir1.getArea());
        System.out.println(cir1.getCircum());
        
        cir2.setXYcoordinates(5, 4);
        cir2.setRadius(7);
        System.out.println(cir2.getXcoordinate());
        System.out.println(cir2.getYcoordinate());
        System.out.println(cir2.getRadius());
        System.out.println(cir2.getArea());
        System.out.println(cir2.getCircum());
    }
    
}
