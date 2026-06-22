package bd.edu.aiub.oop.lab06;

/**
 * Final utility class demonstrating static state and static methods.
 */
public final class IdGenerator {
    private static int sequence = 1000;

    private IdGenerator() {
        throw new IllegalStateException("Utility class cannot be instantiated.");
    }

    /**
     * Generates a new ID.
     *
     * @param prefix ID prefix
     * @return generated ID
     */
    public static String nextId(String prefix) {
        if (prefix == null || prefix.trim().isEmpty()) throw new IllegalArgumentException("Prefix is required.");
        sequence++;
        return prefix.trim().toUpperCase() + "-" + sequence;
    }

    /**
     * Gets current sequence value.
     *
     * @return current sequence
     */
    public static int getSequence() {
        return sequence;
    }
}
