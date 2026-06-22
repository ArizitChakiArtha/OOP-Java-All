package bd.edu.aiub.oop.courseproject.model;

import bd.edu.aiub.oop.courseproject.exception.ValidationException;
import bd.edu.aiub.oop.courseproject.util.CsvUtil;

/**
 * Enrollment entity connecting student, course, and mark.
 */
public class Enrollment implements Identifiable, CsvConvertible {
    private String id;
    private String studentId;
    private String courseCode;
    private double mark;

    /**
     * Creates enrollment.
     *
     * @param id enrollment ID
     * @param studentId student ID
     * @param courseCode course code
     * @param mark mark
     * @throws ValidationException when data is invalid
     */
    public Enrollment(String id, String studentId, String courseCode, double mark) throws ValidationException {
        setId(id);
        setStudentId(studentId);
        setCourseCode(courseCode);
        setMark(mark);
    }

    /** @return enrollment ID */
    @Override
    public String getId() { return id; }

    /** @param id enrollment ID
     * @throws ValidationException when ID is empty */
    public void setId(String id) throws ValidationException {
        if (id == null || id.trim().isEmpty()) throw new ValidationException("Enrollment ID required.");
        this.id = id.trim().toUpperCase();
    }

    /** @return student ID */
    public String getStudentId() { return studentId; }

    /** @param studentId student ID
     * @throws ValidationException when student ID is empty */
    public void setStudentId(String studentId) throws ValidationException {
        if (studentId == null || studentId.trim().isEmpty()) throw new ValidationException("Student ID required.");
        this.studentId = studentId.trim();
    }

    /** @return course code */
    public String getCourseCode() { return courseCode; }

    /** @param courseCode course code
     * @throws ValidationException when course code is invalid */
    public void setCourseCode(String courseCode) throws ValidationException {
        if (courseCode == null || courseCode.trim().length() < 3) throw new ValidationException("Course code required.");
        this.courseCode = courseCode.trim().toUpperCase();
    }

    /** @return mark */
    public double getMark() { return mark; }

    /** @param mark mark
     * @throws ValidationException when mark is invalid */
    public void setMark(double mark) throws ValidationException {
        if (mark < 0 || mark > 100) throw new ValidationException("Mark must be 0 to 100.");
        this.mark = mark;
    }

    /**
     * Gets grade based on mark.
     *
     * @return grade
     */
    public Grade getGrade() { return Grade.fromMark(mark); }

    /** @return CSV row */
    @Override
    public String toCsv() { return CsvUtil.join(id, studentId, courseCode, String.valueOf(mark)); }

    /**
     * Parses enrollment from CSV.
     *
     * @param row CSV row
     * @return enrollment
     * @throws ValidationException when row is invalid
     */
    public static Enrollment fromCsv(String row) throws ValidationException {
        String[] parts = CsvUtil.split(row, 4);
        return new Enrollment(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
    }

    /**
     * Builds enrollment description.
     *
     * @return description
     */
    public String describe() {
        return id + " | Student " + studentId + " | " + courseCode + " | Mark " + mark + " | Grade " + getGrade().getLabel();
    }
}
