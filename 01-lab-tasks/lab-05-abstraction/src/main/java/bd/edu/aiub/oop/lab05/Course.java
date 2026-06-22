package bd.edu.aiub.oop.lab05;

/**
 * Abstract course containing shared state and requiring delivery-mode implementation.
 */
public abstract class Course implements Registrable, Assessable {
    private String code;
    private String title;
    private int credit;

    /**
     * Creates a course.
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

    /** @return course code */
    public String getCode() { return code; }

    /** @param code course code */
    public void setCode(String code) {
        if (code == null || code.trim().length() < 3) throw new IllegalArgumentException("Course code is required.");
        this.code = code.trim().toUpperCase();
    }

    /** @return title */
    public String getTitle() { return title; }

    /** @param title course title */
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title is required.");
        this.title = title.trim();
    }

    /** @return credit */
    public int getCredit() { return credit; }

    /** @param credit credit count */
    public void setCredit(int credit) {
        if (credit < 1 || credit > 4) throw new IllegalArgumentException("Credit must be 1 to 4.");
        this.credit = credit;
    }

    /**
     * Gets delivery mode.
     *
     * @return delivery mode
     */
    public abstract String getDeliveryMode();

    /**
     * Registers a student into the course.
     *
     * @param studentId student ID
     * @return confirmation
     */
    @Override
    public String registerStudent(String studentId) {
        if (studentId == null || studentId.trim().isEmpty()) throw new IllegalArgumentException("Student ID is required.");
        return studentId + " registered for " + code + " (" + getDeliveryMode() + ")";
    }

    /**
     * Builds course description.
     *
     * @return description
     */
    public String describe() {
        return code + " | " + title + " | " + credit + " credits | " + getDeliveryMode();
    }
}
