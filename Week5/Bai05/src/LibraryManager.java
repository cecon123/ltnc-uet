public interface LibraryManager {
    boolean addBook(Book book);
    Book findBookById(String id);
    boolean removeBookById(String id);
    void printAllBooks();
    String getStorageType();
}
