package bd.edu.aiub.oop.exam.finalterm;

/**
 * Faculty subclass for final practical.
 */
public class Faculty extends Person {
    private String rank;

    /**
     * Creates faculty.
     *
     * @param id faculty ID
     * @param name name
     * @param rank academic rank
     */
    public Faculty(String id, String name, String rank) {
        super(id, name);
        setRank(rank);
    }

    /** @return rank */
    public String getRank() { return rank; }

    /** @param rank academic rank */
    public void setRank(String rank) {
        if (rank == null || rank.trim().isEmpty()) throw new IllegalArgumentException("Rank required.");
        this.rank = rank.trim();
    }

    /**
     * Overrides description.
     *
     * @return description
     */
    @Override
    public String describe() { return super.describe() + " | " + rank; }
}
