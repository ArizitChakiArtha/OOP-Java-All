package bd.edu.aiub.oop.courseproject.service;

import bd.edu.aiub.oop.courseproject.exception.RepositoryException;
import bd.edu.aiub.oop.courseproject.exception.ValidationException;
import bd.edu.aiub.oop.courseproject.model.Course;
import bd.edu.aiub.oop.courseproject.repository.CourseRepository;

import java.util.List;

/**
 * Business service for course operations.
 */
public class CourseService {
    private final CourseRepository repository;

    /**
     * Creates service.
     *
     * @param repository course repository
     */
    public CourseService(CourseRepository repository) { this.repository = repository; }

    /**
     * Adds course.
     *
     * @param code code
     * @param title title
     * @param credit credit count
     * @param faculty faculty name
     * @throws ValidationException when data is invalid
     * @throws RepositoryException when persistence fails
     */
    public void addCourse(String code, String title, int credit, String faculty) throws ValidationException, RepositoryException {
        if (repository.findById(code.toUpperCase()) != null) throw new ValidationException("Course already exists.");
        repository.save(new Course(code, title, credit, faculty));
        repository.flush();
    }

    /**
     * Requires course.
     *
     * @param code course code
     * @return course
     * @throws ValidationException when course is missing
     */
    public Course requireCourse(String code) throws ValidationException {
        Course course = repository.findById(code.toUpperCase());
        if (course == null) throw new ValidationException("Course not found: " + code);
        return course;
    }

    /**
     * Lists courses.
     *
     * @return course list
     */
    public List<Course> listCourses() { return repository.findAll(); }
}
