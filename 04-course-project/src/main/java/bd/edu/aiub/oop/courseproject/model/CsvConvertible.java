package bd.edu.aiub.oop.courseproject.model;

/**
 * Contract for objects that can be persisted as CSV.
 */
public interface CsvConvertible {
    /**
     * Converts object to CSV.
     *
     * @return CSV row
     */
    String toCsv();
}
