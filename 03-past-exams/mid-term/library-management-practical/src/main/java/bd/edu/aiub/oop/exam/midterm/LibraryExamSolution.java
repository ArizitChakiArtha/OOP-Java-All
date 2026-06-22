package bd.edu.aiub.oop.exam.midterm;

/**
 * Runs the library practical exam solution.
 */
public class LibraryExamSolution {
    /**
     * Executes sample issue and return operations.
     *
     * @param args unused arguments
     */
    public static void main(String[] args) {
        try {
            Library library = new Library();
            library.addBook(new Book("978-0134685991", "Effective Java", "Joshua Bloch"));
            library.addBook(new Book("978-0596009205", "Head First Java", "Kathy Sierra"));
            library.addMember(new Member("M-101", "Koushik Biswas Arko"));
            library.issueBook("978-0134685991", "M-101");
            library.printBooks();
            library.returnBook("978-0134685991", "M-101");
            library.printBooks();
        } catch (LibraryException exception) {
            System.out.println("Library operation failed: " + exception.getMessage());
        }
    }
}
