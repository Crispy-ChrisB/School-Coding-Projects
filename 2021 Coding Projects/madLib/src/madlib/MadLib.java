package madlib;

import java.util.Scanner;

public class MadLib {

    public static void main(String[] args) {
      
        Scanner word = new Scanner(System.in);
        
        String adj1;
        String adj2;
        String bird;
        String room;
        String ptVerb;
        String verb;
        String name;
        String noun1;
        String liquid;
        String ingVerb1;
        String bodyPart;
        String nounPlural;
        String ingVerb2;
        String noun2;
        
        System.out.println("Enter an adjective");
        adj1 = word.next();
        System.out.println("Enter another adjective");
        adj2 = word.next();
        System.out.println("Enter a type of Bird");
        bird = word.next();
        System.out.println("Enter a room in a house");
        room = word.next();
        System.out.println("Enter a past tense verb");
        ptVerb = word.next();
        System.out.println("Enter a verb");
        verb = word.next();
        System.out.println("Enter a relative's name");
        name = word.next();
        System.out.println("Enter a noun");
        noun1 = word.next();
        System.out.println("Enter a liquid");
        liquid = word.next();
        System.out.println("Enter a verb ending in -ing");
        ingVerb1 = word.next();
        System.out.println("Enter a body part (plural)");
        bodyPart = word.next();
        System.out.println("Enter a plural noun");
        nounPlural = word.next();
        System.out.println("Enter another verb ending in -ing");
        ingVerb2 = word.next();
        System.out.println("Enter another noun");
        noun2 = word.next();
        
        System.out.println("It was a "+adj1+", cold November day.");
        System.out.println("I woke up to the "+adj2+" smell of "+bird+" roasting in the "+room+" downstairs.");
        System.out.println("I "+ptVerb+" down the stairs to see if I could help "+verb+" the dinner.");
        System.out.println("My mom said,'See if "+name+" needs a fresh "+noun1+".'");
        System.out.println("So I carried a tray of glasses full of "+liquid+" into the "+ingVerb1+" room.");
        System.out.println("When I got there, I couldn't believe my "+bodyPart+"!");
        System.out.println("There were "+nounPlural+" "+ingVerb2+" on the "+noun2+"!");
    }
    
}
