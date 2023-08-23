package BookPackB;

public class ExBook extends BookPack.Book{
    private String publisher;

    public ExBook(String t, String a, int d, String p) {
        super(t, a, d);
        publisher = p;
    }

    public void show() {
        super.show();
        System.out.println(publisher);
        System.out.println();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String p) {
        publisher = p;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        title = t;
    }

    public String getAthor() {
        return author;
    }

    public void setAuthor(String a) {
        author = a;
    }

    public int getPubDate() {
        return pubDate;
    }

    public void setPubdate(int d) {
        pubDate = d;
    }
}