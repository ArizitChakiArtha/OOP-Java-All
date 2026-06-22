package bd.edu.aiub.oop.lab06;

/**
 * Demonstrates final field and final method.
 */
public class AcademicRecord {
    private final String recordId;
    private double cgpa;

    /**
     * Creates an academic record.
     *
     * @param recordId permanent record ID
     * @param cgpa cumulative GPA
     */
    public AcademicRecord(String recordId, double cgpa) {
        if (recordId == null || recordId.trim().isEmpty()) throw new IllegalArgumentException("Record ID is required.");
        this.recordId = recordId.trim();
        setCgpa(cgpa);
    }

    /** @return record ID */
    public String getRecordId() { return recordId; }

    /** @return CGPA */
    public double getCgpa() { return cgpa; }

    /** @param cgpa cumulative GPA */
    public void setCgpa(double cgpa) {
        if (cgpa < 0 || cgpa > UniversityConstants.MAX_CGPA) throw new IllegalArgumentException("Invalid CGPA.");
        this.cgpa = cgpa;
    }

    /**
     * Final method that subclasses cannot override.
     *
     * @return true when eligible
     */
    public final boolean isGraduationEligible() {
        return cgpa >= UniversityConstants.MIN_GRADUATION_CGPA;
    }
}
