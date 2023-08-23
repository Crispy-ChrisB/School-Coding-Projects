package BookPack;

public class BookDemo {

    public static void main(String[] args) {
        Book books[] = new Book[5];
        books[0] = new Book("Java: A Beginner’s Guide", "Schildt", 2005);
        books[1] = new Book("Java: The Complete Reference", "Schildt", 2005);
        books[2] = new Book("The Art of Java", "Schildtand Holmes", 2003);
        books[3] = new Book("Red Storm Rising", "Clancy", 1986);
        books[4] = new Book("On the Road", "Kerouac", 1955);
        for (int i = 0; i < 5; i++)
            books[i].show();
    }
    
}
