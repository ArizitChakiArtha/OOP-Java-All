package bd.edu.aiub.oop.courseproject;

import bd.edu.aiub.oop.courseproject.exception.RepositoryException;
import bd.edu.aiub.oop.courseproject.exception.ValidationException;
import bd.edu.aiub.oop.courseproject.model.Course;
import bd.edu.aiub.oop.courseproject.model.Enrollment;
import bd.edu.aiub.oop.courseproject.model.Student;
import bd.edu.aiub.oop.courseproject.repository.CourseRepository;
import bd.edu.aiub.oop.courseproject.repository.EnrollmentRepository;
import bd.edu.aiub.oop.courseproject.repository.StudentRepository;
import bd.edu.aiub.oop.courseproject.service.CourseService;
import bd.edu.aiub.oop.courseproject.service.EnrollmentService;
import bd.edu.aiub.oop.courseproject.service.ReportService;
import bd.edu.aiub.oop.courseproject.service.StudentService;
import bd.edu.aiub.oop.courseproject.util.AppConstants;
import bd.edu.aiub.oop.courseproject.util.InputHelper;

import java.util.Scanner;

/**
 * Console entry point for the AIUB Student Information System course project.
 */
public class Main {
    private final StudentService studentService;
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;
    private final ReportService reportService;
    private final InputHelper inputHelper;

    /**
     * Creates application with service dependencies.
     *
     * @param studentService student service
     * @param courseService course service
     * @param enrollmentService enrollment service
     * @param reportService report service
     * @param inputHelper input helper
     */
    public Main(StudentService studentService, CourseService courseService, EnrollmentService enrollmentService,
                ReportService reportService, InputHelper inputHelper) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.enrollmentService = enrollmentService;
        this.reportService = reportService;
        this.inputHelper = inputHelper;
    }

    /**
     * Starts the menu-driven application.
     */
    public void start() {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = inputHelper.readInt("Choose option: ", 0, 8);
            try {
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        listStudents();
                        break;
                    case 3:
                        addCourse();
                        break;
                    case 4:
                        listCourses();
                        break;
                    case 5:
                        enrollStudent();
                        break;
                    case 6:
                        listEnrollments();
                        break;
                    case 7:
                        printTranscript();
                        break;
                    case 8:
                        deleteStudent();
                        break;
                    case 0:
                        running = false;
                        System.out.println("Application closed.");
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            } catch (ValidationException | RepositoryException exception) {
                System.out.println("Operation failed: " + exception.getMessage());
            }
        }
    }

    /**
     * Application bootstrap.
     *
     * @param args unused arguments
     */
    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository(AppConstants.STUDENT_FILE);
        CourseRepository courseRepository = new CourseRepository(AppConstants.COURSE_FILE);
        EnrollmentRepository enrollmentRepository = new EnrollmentRepository(AppConstants.ENROLLMENT_FILE);
        try {
            studentRepository.load();
            courseRepository.load();
            enrollmentRepository.load();
        } catch (RepositoryException exception) {
            System.out.println("Previous data could not be loaded: " + exception.getMessage());
        }

        StudentService studentService = new StudentService(studentRepository);
        CourseService courseService = new CourseService(courseRepository);
        EnrollmentService enrollmentService = new EnrollmentService(enrollmentRepository, studentService, courseService);
        ReportService reportService = new ReportService(studentService, courseService, enrollmentService);

        try (Scanner scanner = new Scanner(System.in)) {
            Main app = new Main(studentService, courseService, enrollmentService, reportService, new InputHelper(scanner));
            app.start();
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("==== " + AppConstants.APP_TITLE + " ====");
        System.out.println("1. Add student");
        System.out.println("2. List students");
        System.out.println("3. Add course");
        System.out.println("4. List courses");
        System.out.println("5. Enroll student with mark");
        System.out.println("6. List enrollments");
        System.out.println("7. Print transcript");
        System.out.println("8. Delete student");
        System.out.println("0. Exit");
    }

    private void addStudent() throws ValidationException, RepositoryException {
        String id = inputHelper.readText("Student ID: ");
        String name = inputHelper.readText("Name: ");
        String email = inputHelper.readText("Email: ");
        String department = inputHelper.readText("Department: ");
        int credits = inputHelper.readInt("Completed credits: ", 0, 180);
        studentService.addStudent(id, name, email, department, credits);
        System.out.println("Student saved successfully.");
    }

    private void listStudents() {
        if (studentService.listStudents().isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student student : studentService.listStudents()) {
            System.out.println(student.describe());
        }
    }

    private void addCourse() throws ValidationException, RepositoryException {
        String code = inputHelper.readText("Course code: ");
        String title = inputHelper.readText("Course title: ");
        int credit = inputHelper.readInt("Credit: ", 1, 4);
        String faculty = inputHelper.readText("Faculty name: ");
        courseService.addCourse(code, title, credit, faculty);
        System.out.println("Course saved successfully.");
    }

    private void listCourses() {
        if (courseService.listCourses().isEmpty()) {
            System.out.println("No courses found.");
            return;
        }
        for (Course course : courseService.listCourses()) {
            System.out.println(course.describe());
        }
    }

    private void enrollStudent() throws ValidationException, RepositoryException {
        String id = inputHelper.readText("Enrollment ID: ");
        String studentId = inputHelper.readText("Student ID: ");
        String courseCode = inputHelper.readText("Course code: ");
        double mark = inputHelper.readDouble("Mark: ", 0, 100);
        enrollmentService.enroll(id, studentId, courseCode, mark);
        System.out.println("Enrollment saved successfully.");
    }

    private void listEnrollments() {
        if (enrollmentService.listEnrollments().isEmpty()) {
            System.out.println("No enrollments found.");
            return;
        }
        for (Enrollment enrollment : enrollmentService.listEnrollments()) {
            System.out.println(enrollment.describe());
        }
    }

    private void printTranscript() throws ValidationException {
        String studentId = inputHelper.readText("Student ID: ");
        System.out.println(reportService.buildTranscript(studentId));
    }

    private void deleteStudent() throws ValidationException, RepositoryException {
        String studentId = inputHelper.readText("Student ID to delete: ");
        studentService.deleteStudent(studentId);
        System.out.println("Student deleted successfully.");
    }
}
