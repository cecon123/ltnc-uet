public class Book {
    private String title;
    private String author;
    private double price;
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return Double.compare(book.price, price) == 0 &&
                title.equals(book.title) &&
                author.equals(book.author);
    }
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "John Doe", 29.99);
        Book book2 = new Book("Java Programming", "John Doe", 29.99);
        System.out.println("Using == : " + (book1 == book2)); // false
        System.out.println("Using equals : " + book1.equals(book2)); // true
    }

}
