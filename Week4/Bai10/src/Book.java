public class Book extends MediaItem {
    private String author;
    private int pages;

    public Book(String id, String name, String author, int pages) {
        super(id, name);
        this.author = author;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return getName() + " - " + author + " - " + pages + " trang";
    }
}
