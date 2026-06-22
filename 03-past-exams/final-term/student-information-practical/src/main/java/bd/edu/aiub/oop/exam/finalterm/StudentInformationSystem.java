package bd.edu.aiub.oop.exam.finalterm;

import java.util.ArrayList;
import java.util.List;

/**
 * Student information system for final-term practical.
 */
public class StudentInformationSystem {
    private final List<Student> students = new ArrayList<>();
    private final List<Faculty> faculties = new ArrayList<>();
    private final List<Result> results = new ArrayList<>();

    /**
     * Adds student.
     *
     * @param student student
     */
    public void addStudent(Student student) { students.add(student); }

    /**
     * Adds faculty.
     *
     * @param faculty faculty
     */
    public void addFaculty(Faculty faculty) { faculties.add(faculty); }

    /**
     * Adds result.
     *
     * @param result result
     */
    public void addResult(Result result) { results.add(result); }

    /**
     * Prints student result report.
     */
    public void printReport() {
        System.out.println("Student Information System Report");
        for (Student student : students) {
            System.out.println(student.describe());
            for (Result result : results) {
                if (result.getStudentId().equals(student.getId())) {
                    System.out.println("  " + result.getCourseCode() + " | " + result.getMark() + " | " + result.getStatus());
                }
            }
        }
        for (Faculty faculty : faculties) {
            System.out.println("Faculty: " + faculty.describe());
        }
    }
}
