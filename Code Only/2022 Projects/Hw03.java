/*
course: CSC210
project: Hw 03
date: Feb. 10th, 2022
author: Chris Ball
purpose: A program that familiarizes the writer with how 
        subclasses work
*/
package hw03;

import java.util.Date;

class Person {
    String name;
    String address;
    String phoneNumber;
    String emailAddress;
    
    Person(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return "Person: "+name;
    }
}

class Student extends Person{
    String status;
    final int freshman = 1;
    final int sophomore = 2;
    final int junior = 3;
    final int senior = 4;
    
    Student(int status, String name){
        super(name);
        switch(status){
            case 1 -> this.status = "Freshman";
            case 2 -> this.status = "Sophomore";
            case 3 -> this.status = "Junior";
            case 4 -> this.status = "Senior";
        }
    }
    
    @Override
    public String toString(){
        return "Student: "+name+" ("+this.status+")";
    }
}

class Employee extends Person{
    String office;
    double salary;
    Date dateHired;

    public Employee(String name){
        super(name);
    }
    
    @Override
    public String toString(){
        return "Employee: "+name;
    }
}

class Faculty extends Employee{
    String officeHours;
    String rank;
    
    public Faculty(String name){
        super(name);
    }
    
    @Override
    public String toString(){
        return "Faculty: "+name;
    }
}

class Staff extends Employee{
    String title;
    
    public Staff(String name){
        super(name);
    }
    
    @Override
    public String toString(){
        return "Staff: "+name;
    }
}

public class Hw03 {
    
    public static void main(String[] args) {
        Person person = new Person("Peter");
        Student student = new Student(2, "Susan");
        Employee employee = new Employee("Eva");
        Faculty faculty = new Faculty("Frank");
        Staff staff = new Staff("Shane");
        
        System.out.println(person);
        System.out.println(student);
        System.out.println(employee);
        System.out.println(faculty);
        System.out.println(staff);
    }
}