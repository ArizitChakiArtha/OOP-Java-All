package bd.edu.aiub.oop.courseproject.model;

import bd.edu.aiub.oop.courseproject.exception.ValidationException;
import bd.edu.aiub.oop.courseproject.util.CsvUtil;

/**
 * Course entity for the course project.
 */
public class Course implements Identifiable, CsvConvertible {
    private String code;
    private String title;
    private int credit;
    private String faculty;

    /**
     * Creates course.
     *
     * @param code course code
     * @param title title
     * @param credit credit count
     * @param faculty faculty name
     * @throws ValidationException when data is invalid
     */
    public Course(String code, String title, int credit, String faculty) throws ValidationException {
        setCode(code);
        setTitle(title);
        setCredit(credit);
        setFaculty(faculty);
    }

    /** @return ID as course code */
    @Override
    public String getId() { return code; }

    /** @return course code */
    public String getCode() { return code; }

    /** @param code course code
     * @throws ValidationException when code is invalid */
    public void setCode(String code) throws ValidationException {
        if (code == null || code.trim().length() < 3) throw new ValidationException("Course code required.");
        this.code = code.trim().toUpperCase();
    }

    /** @return title */
    public String getTitle() { return title; }

    /** @param title course title
     * @throws ValidationException when title is empty */
    public void setTitle(String title) throws ValidationException {
        if (title == null || title.trim().isEmpty()) throw new ValidationException("Course title required.");
        this.title = title.trim();
    }

    /** @return credit */
    public int getCredit() { return credit; }

    /** @param credit credit count
     * @throws ValidationException when credit is invalid */
    public void setCredit(int credit) throws ValidationException {
        if (credit < 1 || credit > 4) throw new ValidationException("Credit must be 1 to 4.");
        this.credit = credit;
    }

    /** @return faculty */
    public String getFaculty() { return faculty; }

    /** @param faculty faculty name
     * @throws ValidationException when faculty is empty */
    public void setFaculty(String faculty) throws ValidationException {
        if (faculty == null || faculty.trim().length() < 2) throw new ValidationException("Faculty name required.");
        this.faculty = faculty.trim();
    }

    /** @return CSV row */
    @Override
    public String toCsv() { return CsvUtil.join(code, title, String.valueOf(credit), faculty); }

    /**
     * Parses course from CSV.
     *
     * @param row CSV row
     * @return course
     * @throws ValidationException when row is invalid
     */
    public static Course fromCsv(String row) throws ValidationException {
        String[] parts = CsvUtil.split(row, 4);
        return new Course(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]);
    }

    /**
     * Builds course description.
     *
     * @return description
     */
    public String describe() { return code + " | " + title + " | " + credit + " credits | Faculty " + faculty; }
}
