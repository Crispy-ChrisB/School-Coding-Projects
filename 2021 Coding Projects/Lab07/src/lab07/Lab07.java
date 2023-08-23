// course: CSC189
// project: Lab07
// date: Oct. 8, 2021
// author: Chris Ball
// purpose: Set up classes to find the area/volume and perimeter/surface area of a triangle, sphere, cylinder, rectangular cuboid, and regular tetrahedron.
package lab07;

class Triangle {
    double p1x,p1y,p2x,p2y,p3x,p3y; //x and y of each point
    double side1, side2, side3;
    
    //Constructor
    Triangle(){
        side1 = 0;
        side2 = 0;
        side3 = 0;
    }
    Triangle(double x1, double y1, double x2, double y2, double x3, double y3){
        p1x = x1;
        p2x = x2;
        p3x = x3;
        p1y = y1;
        p2y = y2;
        p3y = y3;
        side1 = Math.abs(Math.sqrt((p2x-p1x)*(p2x-p1x)+(p2y-p1y)*(p2y-p1y)));
        side2 = Math.abs(Math.sqrt((p3x-p1x)*(p3x-p1x)+(p3y-p1y)*(p3y-p1y)));
        side3 = Math.abs(Math.sqrt((p3x-p2x)*(p3x-p2x)+(p3y-p2y)*(p3y-p2y)));
    }
    
    //Getters
    double getArea(){
        return (getPerimeter()*(getPerimeter()-side1)*(getPerimeter()-side2)*(getPerimeter()-side3));
    }
    double getPerimeter(){
        return side1+side2+side3;
    }
    
    //Mutators
    void setTrianglePoint1(double x, double y){
        p1x = x;
        p1y = y;
    }
    void setTrianglePoint2(double x, double y){
        p2x = x;
        p2y = y;
    }
    void setTrianglePoint3(double x, double y){
        p3x = x;
        p3y = y;
    }
    void setTriangleSides(double s1, double s2, double s3){
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }
}

class Sphere {
    final double PI = 3.14159;
    double radius;
    
    //Constructor
    Sphere(){
        radius = 0;
    }
    Sphere(double r){
        radius = r;
    }
    
    //Getters
    double getVolume(){
        return ((4/3)*PI*radius*radius*radius);
    }
    double getSurfaceArea(){
        return (4*PI*radius*radius);
    }
    
    //Mutators
    void setSphere(double r) {
        radius = r;
    }
}

class Cylinder {
    double radius, height;
    final double PI = 3.14159;
    
    //Constructor
    Cylinder(){
        radius = 0;
        height = 0;
    }
    Cylinder(double r, double h){
        radius = r;
        height = h;
    }
    
    //Getters
    double getVolume(){
        return (PI*radius*radius*height);
    }
    double getSurfaceArea(){
        return ((PI*radius*radius)+(PI*radius*radius)+(2*PI*radius*height));
    }
    
    //Mutators
    void setCylinder(double r, double h){
        radius = r;
        height = h;
    }
}
class RectCuboid {
    double length, depth, height;
    
    //Constructor
    RectCuboid(){
        length = 0;
        depth = 0;
        height = 0;
    }
    RectCuboid(double l, double d, double h){
        length = l;
        depth = d;
        height = h;
    }
    
    //Getters
    double getVolume(){
        return (length*depth*height);
    }
    double getSurfaceArea(){
        return (2*((length*depth)+(length*height)+(depth*height)));
    }
    
    //Mutators
    void setRectCuboid(double l, double d, double h){
        length = l;
        depth = d;
        height = h;
    }
}

class RegTetrahedron {
    double edgeLength;
    final double x = 6*(Math.sqrt(2)); //denominator for Volume
    final double y = (Math.sqrt(3)); //multiplier for Surface Area
    
    //Constructor
    RegTetrahedron(){
        edgeLength = 0;
    }
    RegTetrahedron(double a){
        edgeLength = a;
    }
    
    //Getters
    double getVolume(){
        return ((edgeLength*edgeLength*edgeLength)/x);
    }
    double getSurfaceArea(){
        return (y*edgeLength*edgeLength);
    }
    
    //Mutators
    void setRegTetrahedron(double a){
        edgeLength = a;
    }
}

public class Lab07 {
    public static void main(String[] args) {
        //Triangle Test
        System.out.println("Triangle Test");
        Triangle tri1 = new Triangle();
        Triangle tri2 = new Triangle(0,0,1,5,3,3);
        System.out.println(tri1.getArea());
        System.out.println(tri1.getPerimeter());
        System.out.println(tri2.getArea());
        System.out.println(tri2.getPerimeter());
        tri1.setTriangleSides(3, 4, 5);
        System.out.println(tri1.getPerimeter());
        
        //Sphere Test
        System.out.println("Sphere Test");
        Sphere sphr1 = new Sphere();
        System.out.println(sphr1.getVolume());
        System.out.println(sphr1.getSurfaceArea());
        sphr1.setSphere(5);
        System.out.println(sphr1.getVolume());
        System.out.println(sphr1.getSurfaceArea());
        
        //Cylinder Test
        System.out.println("Cylinder Test");
        Cylinder cyl = new Cylinder();
        System.out.println(cyl.getVolume());
        System.out.println(cyl.getSurfaceArea());
        cyl.setCylinder(2, 4);
        System.out.println(cyl.getVolume());
        System.out.println(cyl.getSurfaceArea());
        
        //Cuboid Test
        System.out.println("RectCuboid Test");
        RectCuboid rec = new RectCuboid();
        System.out.println(rec.getSurfaceArea());
        System.out.println(rec.getVolume());
        rec.setRectCuboid(2, 3, 4);
        System.out.println(rec.getSurfaceArea());
        System.out.println(rec.getVolume());
        
        //RegTetra Test
        System.out.println("RegTetrahedron Test");
        RegTetrahedron tetra = new RegTetrahedron();
        System.out.println(tetra.getVolume());
        System.out.println(tetra.getSurfaceArea());
        tetra.setRegTetrahedron(5);
        System.out.println(tetra.getVolume());
        System.out.println(tetra.getSurfaceArea());
    }
    
}
