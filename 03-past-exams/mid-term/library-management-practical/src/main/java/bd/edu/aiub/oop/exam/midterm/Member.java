package bd.edu.aiub.oop.exam.midterm;

/**
 * Library member entity.
 */
public class Member {
    private String id;
    private String name;
    private int issuedCount;

    /**
     * Creates member.
     *
     * @param id member ID
     * @param name member name
     */
    public Member(String id, String name) {
        setId(id);
        setName(name);
    }

    /** @return member ID */
    public String getId() { return id; }

    /** @param id member ID */
    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) throw new IllegalArgumentException("Member ID required.");
        this.id = id.trim();
    }

    /** @return name */
    public String getName() { return name; }

    /** @param name member name */
    public void setName(String name) {
        if (name == null || name.trim().length() < 2) throw new IllegalArgumentException("Name required.");
        this.name = name.trim();
    }

    /** @return issued book count */
    public int getIssuedCount() { return issuedCount; }

    /**
     * Increases issued count.
     */
    public void increaseIssuedCount() { issuedCount++; }

    /**
     * Decreases issued count.
     */
    public void decreaseIssuedCount() { if (issuedCount > 0) issuedCount--; }
}
