package BookPack;

public class UseBook {
    public static void main(String[] args) {
        BookPack.Book books[] = new BookPack.Book[5];
    
        books[0] = new BookPack.Book("Java: A Beginner’s Guide", "Schildt", 2005);
        books[1] = new BookPack.Book("Java: The Complete Reference", "Schildt", 2005);
        books[2] = new BookPack.Book("The Art of Java", "Schildtand Holmes", 2003);
        books[3] = new BookPack.Book("Red Storm Rising", "Clancy", 1986);
        books[4] = new BookPack.Book("On the Road", "Kerouac", 1955);
        for (Book book : books) {
            book.show();
        }
    }
}