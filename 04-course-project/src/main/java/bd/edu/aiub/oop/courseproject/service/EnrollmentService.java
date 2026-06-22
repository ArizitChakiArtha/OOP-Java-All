package bd.edu.aiub.oop.courseproject.service;

import bd.edu.aiub.oop.courseproject.exception.RepositoryException;
import bd.edu.aiub.oop.courseproject.exception.ValidationException;
import bd.edu.aiub.oop.courseproject.model.Enrollment;
import bd.edu.aiub.oop.courseproject.repository.EnrollmentRepository;

import java.util.List;

/**
 * Business service for enrollment and grading.
 */
public class EnrollmentService {
    private final EnrollmentRepository repository;
    private final StudentService studentService;
    private final CourseService courseService;

    /**
     * Creates service.
     *
     * @param repository enrollment repository
     * @param studentService student service
     * @param courseService course service
     */
    public EnrollmentService(EnrollmentRepository repository, StudentService studentService, CourseService courseService) {
        this.repository = repository;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    /**
     * Enrolls student into a course.
     *
     * @param id enrollment ID
     * @param studentId student ID
     * @param courseCode course code
     * @param mark mark
     * @throws ValidationException when rule fails
     * @throws RepositoryException when persistence fails
     */
    public void enroll(String id, String studentId, String courseCode, double mark) throws ValidationException, RepositoryException {
        studentService.requireStudent(studentId);
        courseService.requireCourse(courseCode);
        if (repository.findById(id.toUpperCase()) != null) throw new ValidationException("Enrollment already exists.");
        repository.save(new Enrollment(id, studentId, courseCode, mark));
        repository.flush();
    }

    /**
     * Lists enrollments.
     *
     * @return enrollment list
     */
    public List<Enrollment> listEnrollments() { return repository.findAll(); }
}
