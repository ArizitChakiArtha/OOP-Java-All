package bd.edu.aiub.oop.courseproject.repository;

import bd.edu.aiub.oop.courseproject.exception.ValidationException;
import bd.edu.aiub.oop.courseproject.model.Student;

import java.nio.file.Path;

/**
 * Repository for students.
 */
public class StudentRepository extends AbstractCsvRepository<Student> {
    /**
     * Creates student repository.
     *
     * @param filePath CSV path
     */
    public StudentRepository(Path filePath) { super(filePath); }

    /**
     * Converts row to student.
     *
     * @param row CSV row
     * @return student
     * @throws ValidationException when row is invalid
     */
    @Override
    protected Student fromCsv(String row) throws ValidationException { return Student.fromCsv(row); }
}
