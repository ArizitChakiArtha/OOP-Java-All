package bd.edu.aiub.oop.exam.midterm;

import java.util.HashMap;
import java.util.Map;

/**
 * Library management solution for AIUB-style mid-term practical.
 */
public class Library {
    private static final int ISSUE_LIMIT = 3;
    private final Map<String, Book> books = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();

    /**
     * Adds a book.
     *
     * @param book book object
     */
    public void addBook(Book book) { books.put(book.getIsbn(), book); }

    /**
     * Adds a member.
     *
     * @param member member object
     */
    public void addMember(Member member) { members.put(member.getId(), member); }

    /**
     * Issues a book.
     *
     * @param isbn ISBN
     * @param memberId member ID
     * @throws LibraryException when issue rule fails
     */
    public void issueBook(String isbn, String memberId) throws LibraryException {
        Book book = requireBook(isbn);
        Member member = requireMember(memberId);
        if (book.isIssued()) throw new LibraryException("Book already issued.");
        if (member.getIssuedCount() >= ISSUE_LIMIT) throw new LibraryException("Member issue limit reached.");
        book.issue();
        member.increaseIssuedCount();
    }

    /**
     * Returns a book.
     *
     * @param isbn ISBN
     * @param memberId member ID
     * @throws LibraryException when return rule fails
     */
    public void returnBook(String isbn, String memberId) throws LibraryException {
        Book book = requireBook(isbn);
        Member member = requireMember(memberId);
        if (!book.isIssued()) throw new LibraryException("Book was not issued.");
        book.returnBook();
        member.decreaseIssuedCount();
    }

    /**
     * Prints all books.
     */
    public void printBooks() {
        for (Book book : books.values()) {
            System.out.println(book.describe());
        }
    }

    private Book requireBook(String isbn) throws LibraryException {
        Book book = books.get(isbn);
        if (book == null) throw new LibraryException("Book not found.");
        return book;
    }

    private Member requireMember(String id) throws LibraryException {
        Member member = members.get(id);
        if (member == null) throw new LibraryException("Member not found.");
        return member;
    }
}
