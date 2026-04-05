import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ArrayListLibrary implements LibraryManager {

    private List<Book> books;

    public ArrayListLibrary() {
        books = new ArrayList<>();
    }

    @Override
    public boolean addBook(Book book) {
        for (Book b : books) {
            if (b.getId().equals(book.getId())) {
                return false;
            }
        }
        books.add(book);
        return true;
    }

    @Override
    public Book findBookById(String id) {
        for (Book b : books) {
            if (b.getId().equals(id)) {
                return b;
            }
        }
        return null;
    }

    @Override
    public boolean removeBookById(String id) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book b = iterator.next();
            if (b.getId().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("List of empty books.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    @Override
    public String getStorageType() {
        return "ArrayList";
    }
}
