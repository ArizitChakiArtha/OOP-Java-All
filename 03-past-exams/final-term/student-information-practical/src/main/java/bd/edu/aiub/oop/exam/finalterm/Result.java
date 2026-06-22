package bd.edu.aiub.oop.exam.finalterm;

/**
 * Result data for one student and course.
 */
public class Result {
    private String studentId;
    private String courseCode;
    private double mark;

    /**
     * Creates result.
     *
     * @param studentId student ID
     * @param courseCode course code
     * @param mark mark
     */
    public Result(String studentId, String courseCode, double mark) {
        setStudentId(studentId);
        setCourseCode(courseCode);
        setMark(mark);
    }

    /** @return student ID */
    public String getStudentId() { return studentId; }

    /** @param studentId student ID */
    public void setStudentId(String studentId) {
        if (studentId == null || studentId.trim().isEmpty()) throw new IllegalArgumentException("Student ID required.");
        this.studentId = studentId.trim();
    }

    /** @return course code */
    public String getCourseCode() { return courseCode; }

    /** @param courseCode course code */
    public void setCourseCode(String courseCode) {
        if (courseCode == null || courseCode.trim().isEmpty()) throw new IllegalArgumentException("Course code required.");
        this.courseCode = courseCode.trim().toUpperCase();
    }

    /** @return mark */
    public double getMark() { return mark; }

    /** @param mark mark */
    public void setMark(double mark) {
        if (mark < 0 || mark > 100) throw new IllegalArgumentException("Mark must be 0 to 100.");
        this.mark = mark;
    }

    /**
     * Gets pass/fail status.
     *
     * @return result status
     */
    public String getStatus() { return mark >= 50 ? "Passed" : "Failed"; }
}
