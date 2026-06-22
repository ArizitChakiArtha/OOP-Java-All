package bd.edu.aiub.oop.courseproject.util;

/**
 * Small CSV utility for simple comma-separated data.
 */
public final class CsvUtil {
    private CsvUtil() { throw new IllegalStateException("Utility class cannot be instantiated."); }

    /**
     * Joins values safely for this project's CSV files.
     *
     * @param values values to join
     * @return CSV row
     */
    public static String join(String... values) {
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < values.length; index++) {
            if (index > 0) builder.append(',');
            builder.append(clean(values[index]));
        }
        return builder.toString();
    }

    /**
     * Splits and validates a CSV row.
     *
     * @param row CSV row
     * @param expected expected field count
     * @return values
     */
    public static String[] split(String row, int expected) {
        String[] parts = row.split(",", -1);
        if (parts.length != expected) throw new IllegalArgumentException("Invalid CSV field count.");
        return parts;
    }

    /**
     * Removes unsupported CSV characters.
     *
     * @param value raw value
     * @return cleaned value
     */
    public static String clean(String value) {
        return value == null ? "" : value.replace(",", " ").replace("\n", " ").trim();
    }
}
