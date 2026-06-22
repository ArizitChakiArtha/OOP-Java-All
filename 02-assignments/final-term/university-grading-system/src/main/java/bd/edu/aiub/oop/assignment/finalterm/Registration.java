package bd.edu.aiub.oop.assignment.finalterm;

/**
 * Student course registration with result.
 */
public class Registration {
    private Student student;
    private Course course;
    private double mark;
    private LetterGrade grade;

    /**
     * Creates registration.
     *
     * @param student student
     * @param course course
     * @param mark mark
     * @param policy grade policy
     */
    public Registration(Student student, Course course, double mark, GradePolicy policy) {
        setStudent(student);
        setCourse(course);
        updateMark(mark, policy);
    }

    /** @return student */
    public Student getStudent() { return student; }

    /** @param student student */
    public void setStudent(Student student) {
        if (student == null) throw new IllegalArgumentException("Student required.");
        this.student = student;
    }

    /** @return course */
    public Course getCourse() { return course; }

    /** @param course course */
    public void setCourse(Course course) {
        if (course == null) throw new IllegalArgumentException("Course required.");
        this.course = course;
    }

    /** @return mark */
    public double getMark() { return mark; }

    /** @return grade */
    public LetterGrade getGrade() { return grade; }

    /**
     * Updates mark and grade.
     *
     * @param mark numeric mark
     * @param policy grade policy
     */
    public void updateMark(double mark, GradePolicy policy) {
        if (policy == null) throw new IllegalArgumentException("Grade policy required.");
        this.grade = policy.resolve(mark);
        this.mark = mark;
    }

    /**
     * Calculates weighted grade points.
     *
     * @return weighted grade points
     */
    public double getWeightedPoint() { return grade.getPoint() * course.getCredit(); }
}
