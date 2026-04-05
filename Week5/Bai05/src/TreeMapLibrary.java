import java.util.Map;
import java.util.TreeMap;

class TreeMapLibrary implements LibraryManager {

    private Map<String, Book> books;

    public TreeMapLibrary() {
        books = new TreeMap<>();
    }

    @Override
    public boolean addBook(Book book) {
        if (books.containsKey(book.getId())) {
            return false;
        }
        books.put(book.getId(), book);
        return true;
    }

    @Override
    public Book findBookById(String id) {
        return books.get(id);
    }

    @Override
    public boolean removeBookById(String id) {
        return books.remove(id) != null;
    }

    @Override
    public void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("List of empty books.");
            return;
        }
        for (Book b : books.values()) {
            System.out.println(b);
        }
    }

    @Override
    public String getStorageType() {
        return "TreeMap";
    }
}
