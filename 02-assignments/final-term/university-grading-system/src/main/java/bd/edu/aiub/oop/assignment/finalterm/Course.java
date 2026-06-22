package bd.edu.aiub.oop.assignment.finalterm;

/**
 * Course in grading system.
 */
public class Course {
    private String code;
    private String title;
    private int credit;

    /**
     * Creates course.
     *
     * @param code course code
     * @param title course title
     * @param credit credit count
     */
    public Course(String code, String title, int credit) {
        setCode(code);
        setTitle(title);
        setCredit(credit);
    }

    /** @return code */
    public String getCode() { return code; }

    /** @param code course code */
    public void setCode(String code) {
        if (code == null || code.trim().length() < 3) throw new IllegalArgumentException("Course code required.");
        this.code = code.trim().toUpperCase();
    }

    /** @return title */
    public String getTitle() { return title; }

    /** @param title course title */
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title required.");
        this.title = title.trim();
    }

    /** @return credit */
    public int getCredit() { return credit; }

    /** @param credit credit count */
    public void setCredit(int credit) {
        if (credit < 1 || credit > 4) throw new IllegalArgumentException("Credit must be 1 to 4.");
        this.credit = credit;
    }
}
