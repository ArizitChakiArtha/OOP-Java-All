package bd.edu.aiub.oop.courseproject.util;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Final constants class for the console project.
 */
public final class AppConstants {
    /** Application title. */
    public static final String APP_TITLE = "AIUB Student Information System";
    /** Data directory. */
    public static final Path DATA_DIR = Paths.get("data");
    /** Student CSV path. */
    public static final Path STUDENT_FILE = DATA_DIR.resolve("students.csv");
    /** Course CSV path. */
    public static final Path COURSE_FILE = DATA_DIR.resolve("courses.csv");
    /** Enrollment CSV path. */
    public static final Path ENROLLMENT_FILE = DATA_DIR.resolve("enrollments.csv");

    private AppConstants() { throw new IllegalStateException("Constants class cannot be instantiated."); }
}
