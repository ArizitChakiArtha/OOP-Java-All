package bd.edu.aiub.oop.lab06;

/**
 * Final constants class demonstrating class-level constants.
 */
public final class UniversityConstants {
    /** Official university name. */
    public static final String UNIVERSITY_NAME = "American International University-Bangladesh";
    /** Highest possible CGPA. */
    public static final double MAX_CGPA = 4.00;
    /** Minimum graduation CGPA. */
    public static final double MIN_GRADUATION_CGPA = 2.50;

    private UniversityConstants() {
        throw new IllegalStateException("Constants class cannot be instantiated.");
    }
}
