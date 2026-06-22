package bd.edu.aiub.oop.courseproject.repository;

import bd.edu.aiub.oop.courseproject.exception.ValidationException;
import bd.edu.aiub.oop.courseproject.model.Course;

import java.nio.file.Path;

/**
 * Repository for courses.
 */
public class CourseRepository extends AbstractCsvRepository<Course> {
    /**
     * Creates course repository.
     *
     * @param filePath CSV path
     */
    public CourseRepository(Path filePath) { super(filePath); }

    /**
     * Converts row to course.
     *
     * @param row CSV row
     * @return course
     * @throws ValidationException when row is invalid
     */
    @Override
    protected Course fromCsv(String row) throws ValidationException { return Course.fromCsv(row); }
}
