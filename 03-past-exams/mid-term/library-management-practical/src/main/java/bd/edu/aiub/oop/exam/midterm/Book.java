package bd.edu.aiub.oop.exam.midterm;

/**
 * Library book entity.
 */
public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean issued;

    /**
     * Creates a book.
     *
     * @param isbn ISBN
     * @param title title
     * @param author author
     */
    public Book(String isbn, String title, String author) {
        setIsbn(isbn);
        setTitle(title);
        setAuthor(author);
    }

    /** @return ISBN */
    public String getIsbn() { return isbn; }

    /** @param isbn ISBN */
    public void setIsbn(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) throw new IllegalArgumentException("ISBN required.");
        this.isbn = isbn.trim();
    }

    /** @return title */
    public String getTitle() { return title; }

    /** @param title title */
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title required.");
        this.title = title.trim();
    }

    /** @return author */
    public String getAuthor() { return author; }

    /** @param author author name */
    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) throw new IllegalArgumentException("Author required.");
        this.author = author.trim();
    }

    /** @return true when issued */
    public boolean isIssued() { return issued; }

    /**
     * Marks book as issued.
     */
    public void issue() { issued = true; }

    /**
     * Marks book as returned.
     */
    public void returnBook() { issued = false; }

    /**
     * Builds book description.
     *
     * @return description
     */
    public String describe() {
        return isbn + " | " + title + " | " + author + " | " + (issued ? "Issued" : "Available");
    }
}
