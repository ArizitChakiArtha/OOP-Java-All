package bd.edu.aiub.oop.courseproject.repository;

import bd.edu.aiub.oop.courseproject.exception.ValidationException;
import bd.edu.aiub.oop.courseproject.model.Enrollment;

import java.nio.file.Path;

/**
 * Repository for enrollments.
 */
public class EnrollmentRepository extends AbstractCsvRepository<Enrollment> {
    /**
     * Creates enrollment repository.
     *
     * @param filePath CSV path
     */
    public EnrollmentRepository(Path filePath) { super(filePath); }

    /**
     * Converts row to enrollment.
     *
     * @param row CSV row
     * @return enrollment
     * @throws ValidationException when row is invalid
     */
    @Override
    protected Enrollment fromCsv(String row) throws ValidationException { return Enrollment.fromCsv(row); }
}
