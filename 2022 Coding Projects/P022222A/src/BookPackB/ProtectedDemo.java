package BookPackB;

public class ProtectedDemo {
    public static void main(String[] args) {
        ExBook books[] = new ExBook[5];
        books[0] = new ExBook("Java: A Beginner’s Guide", "Schildt", 2005, "McGraw-Hill");
        books[1] = new ExBook("Java: The Complete Reference", "Schildt", 2005, "McGraw-Hill");
        books[2] = new ExBook("The Art of Java", "Schildtand Holmes", 2003, "McGraw-Hill");
        books[3] = new ExBook("Red Storm Rising", "Clancy", 1986, "Putnam");
        books[4] = new ExBook("On the Road", "Kerouac", 1955, "Viking");
        for (int i = 0; i < books.length; i++) {
            books[i].show();
        }
    }
}
