package bd.edu.aiub.oop.courseproject.service;

import bd.edu.aiub.oop.courseproject.exception.RepositoryException;
import bd.edu.aiub.oop.courseproject.exception.ValidationException;
import bd.edu.aiub.oop.courseproject.model.Student;
import bd.edu.aiub.oop.courseproject.repository.StudentRepository;

import java.util.List;

/**
 * Business service for student operations.
 */
public class StudentService {
    private final StudentRepository repository;

    /**
     * Creates service.
     *
     * @param repository student repository
     */
    public StudentService(StudentRepository repository) { this.repository = repository; }

    /**
     * Adds student.
     *
     * @param id student ID
     * @param name name
     * @param email email
     * @param department department
     * @param credits completed credits
     * @throws ValidationException when data is invalid
     * @throws RepositoryException when persistence fails
     */
    public void addStudent(String id, String name, String email, String department, int credits) throws ValidationException, RepositoryException {
        if (repository.findById(id) != null) throw new ValidationException("Student already exists.");
        repository.save(new Student(id, name, email, department, credits));
        repository.flush();
    }

    /**
     * Deletes student.
     *
     * @param id student ID
     * @throws ValidationException when student is missing
     * @throws RepositoryException when persistence fails
     */
    public void deleteStudent(String id) throws ValidationException, RepositoryException {
        if (!repository.deleteById(id)) throw new ValidationException("Student not found.");
        repository.flush();
    }

    /**
     * Requires student.
     *
     * @param id student ID
     * @return student
     * @throws ValidationException when student is missing
     */
    public Student requireStudent(String id) throws ValidationException {
        Student student = repository.findById(id);
        if (student == null) throw new ValidationException("Student not found: " + id);
        return student;
    }

    /**
     * Lists students.
     *
     * @return student list
     */
    public List<Student> listStudents() { return repository.findAll(); }
}
