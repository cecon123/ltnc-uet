public class Main {

    public static void testLibrary(LibraryManager library) {
        System.out.println("\n==============================");
        System.out.println(
            "Testing with structures:" + library.getStorageType()
        );
        System.out.println("==============================");

        // Add 5 books
        System.out.println("\n1. Add books:");
        System.out.println(
            "Add B001: " +
                library.addBook(
                    new Book("B001", "Java Programming", "James Gosling", 2020)
                )
        );
        System.out.println(
            "Add B002: " +
                library.addBook(
                    new Book("B002", "Data Structures", "Mark Allen", 2018)
                )
        );
        System.out.println(
            "Add B003: " +
                library.addBook(
                    new Book("B003", "Algorithms", "Thomas Cormen", 2009)
                )
        );
        System.out.println(
            "Add B004: " +
                library.addBook(
                    new Book("B004", "Database Systems", "Elmasri", 2017)
                )
        );
        System.out.println(
            "Add B005: " +
                library.addBook(
                    new Book("B005", "Operating Systems", "Silberschatz", 2015)
                )
        );

        // Try adding duplicate IDs
        System.out.println(
            "Add duplicate B003: " +
                library.addBook(
                    new Book("B003", "Duplicate Book", "Unknown", 2024)
                )
        );

        // Print list
        System.out.println("\n2. Current book list:");
        library.printAllBooks();

        // Search for books by ID
        System.out.println("\n3. Search for books by ID:");
        String searchId = "B003";
        Book found = library.findBookById(searchId);
        if (found != null) {
            System.out.println("Found book with ID " + searchId + ": " + found);
        } else {
            System.out.println("No books with that ID were found " + searchId);
        }

        // Search for a non-existent book
        searchId = "B999";
        found = library.findBookById(searchId);
        if (found != null) {
            System.out.println("Found book with ID " + searchId + ": " + found);
        } else {
            System.out.println("No books with that ID were found " + searchId);
        }

        // Delete a book
        System.out.println("\n4. Delete book by ID:");
        String removeId = "B002";
        boolean removed = library.removeBookById(removeId);
        System.out.println("Deleted book " + removeId + ": " + removed);

        // Delete a non-existent book
        removeId = "B999";
        removed = library.removeBookById(removeId);
        System.out.println("Deleted book " + removeId + ": " + removed);

        // Print list after deletion
        System.out.println("\n5. List after deletion:");
        library.printAllBooks();
    }

    public static void main(String[] args) {
        LibraryManager arrayListLibrary = new ArrayListLibrary();
        LibraryManager hashMapLibrary = new HashMapLibrary();
        LibraryManager treeMapLibrary = new TreeMapLibrary();

        testLibrary(arrayListLibrary);
        testLibrary(hashMapLibrary);
        testLibrary(treeMapLibrary);
    }
}
