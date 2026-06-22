package bd.edu.aiub.oop.lab07;

/**
 * Student record demonstrating throw and throws with custom exceptions.
 */
public class StudentRecord {
    private String studentId;
    private double cgpa;
    private int completedCredits;

    /**
     * Creates a student record.
     *
     * @param studentId student ID
     * @param cgpa cumulative GPA
     * @param completedCredits completed credits
     * @throws InvalidCgpaException when CGPA is invalid
     * @throws EnrollmentException when credits are invalid
     */
    public StudentRecord(String studentId, double cgpa, int completedCredits) throws InvalidCgpaException, EnrollmentException {
        setStudentId(studentId);
        setCgpa(cgpa);
        setCompletedCredits(completedCredits);
    }

    /** @return student ID */
    public String getStudentId() { return studentId; }

    /** @param studentId student ID */
    public void setStudentId(String studentId) {
        if (studentId == null || studentId.trim().isEmpty()) throw new IllegalArgumentException("Student ID required.");
        this.studentId = studentId.trim();
    }

    /** @return CGPA */
    public double getCgpa() { return cgpa; }

    /** @param cgpa cumulative GPA
     * @throws InvalidCgpaException when CGPA is invalid */
    public void setCgpa(double cgpa) throws InvalidCgpaException {
        if (cgpa < 0 || cgpa > 4) throw new InvalidCgpaException("CGPA must be 0.00 to 4.00.");
        this.cgpa = cgpa;
    }

    /** @return completed credits */
    public int getCompletedCredits() { return completedCredits; }

    /** @param completedCredits completed credits
     * @throws EnrollmentException when credits are invalid */
    public void setCompletedCredits(int completedCredits) throws EnrollmentException {
        if (completedCredits < 0 || completedCredits > 180) throw new EnrollmentException("Credits must be 0 to 180.");
        this.completedCredits = completedCredits;
    }

    /**
     * Validates graduation eligibility.
     *
     * @throws EnrollmentException when student is not eligible
     */
    public void validateGraduation() throws EnrollmentException {
        if (completedCredits < 148) throw new EnrollmentException("At least 148 credits required.");
        if (cgpa < 2.50) throw new EnrollmentException("CGPA must be at least 2.50.");
    }
}
