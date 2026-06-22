package bd.edu.aiub.oop.lab03;

/**
 * Faculty class in the Person -> Employee -> Faculty hierarchy.
 */
public class Faculty extends Employee {
    private String rank;
    private int courseCount;

    /**
     * Creates a faculty member.
     *
     * @param id faculty ID
     * @param name name
     * @param email email
     * @param salary base salary
     * @param rank academic rank
     * @param courseCount number of courses
     */
    public Faculty(String id, String name, String email, double salary, String rank, int courseCount) {
        super(id, name, email, "Faculty", salary);
        setRank(rank);
        setCourseCount(courseCount);
    }

    /** @return academic rank */
    public String getRank() { return rank; }

    /** @param rank academic rank */
    public void setRank(String rank) {
        if (rank == null || rank.trim().isEmpty()) throw new IllegalArgumentException("Rank is required.");
        this.rank = rank.trim();
    }

    /** @return course count */
    public int getCourseCount() { return courseCount; }

    /** @param courseCount number of assigned courses */
    public void setCourseCount(int courseCount) {
        if (courseCount < 0 || courseCount > 6) throw new IllegalArgumentException("Course count must be 0 to 6.");
        this.courseCount = courseCount;
    }

    /**
     * Calculates faculty salary with course allowance.
     *
     * @return payable salary
     */
    @Override
    public double calculateSalary() { return getSalary() + courseCount * 2500.0; }

    /**
     * Overrides employee description.
     *
     * @return faculty description
     */
    @Override
    public String describe() { return super.describe() + " | " + rank + " | Courses " + courseCount; }
}
