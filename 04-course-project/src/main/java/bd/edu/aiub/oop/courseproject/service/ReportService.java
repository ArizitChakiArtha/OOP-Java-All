package bd.edu.aiub.oop.courseproject.service;

import bd.edu.aiub.oop.courseproject.exception.ValidationException;
import bd.edu.aiub.oop.courseproject.model.Course;
import bd.edu.aiub.oop.courseproject.model.Enrollment;
import bd.edu.aiub.oop.courseproject.model.Student;

/**
 * Reporting service for transcript and CGPA.
 */
public class ReportService {
    private final StudentService studentService;
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;

    /**
     * Creates service.
     *
     * @param studentService student service
     * @param courseService course service
     * @param enrollmentService enrollment service
     */
    public ReportService(StudentService studentService, CourseService courseService, EnrollmentService enrollmentService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.enrollmentService = enrollmentService;
    }

    /**
     * Builds transcript.
     *
     * @param studentId student ID
     * @return transcript text
     * @throws ValidationException when student or course is missing
     */
    public String buildTranscript(String studentId) throws ValidationException {
        Student student = studentService.requireStudent(studentId);
        StringBuilder builder = new StringBuilder();
        builder.append("Transcript for ").append(student.getName()).append(" (").append(student.getId()).append(")\n");
        builder.append("Department: ").append(student.getDepartment()).append("\n");
        double totalPoints = 0;
        int totalCredits = 0;
        for (Enrollment enrollment : enrollmentService.listEnrollments()) {
            if (enrollment.getStudentId().equals(studentId)) {
                Course course = courseService.requireCourse(enrollment.getCourseCode());
                totalPoints += enrollment.getGrade().getPoint() * course.getCredit();
                totalCredits += course.getCredit();
                builder.append(course.getCode()).append(" | ")
                        .append(course.getTitle()).append(" | Mark ")
                        .append(String.format("%.2f", enrollment.getMark())).append(" | ")
                        .append(enrollment.getGrade().getLabel()).append("\n");
            }
        }
        double cgpa = totalCredits == 0 ? 0 : totalPoints / totalCredits;
        builder.append("Total Credits: ").append(totalCredits).append("\n");
        builder.append("CGPA: ").append(String.format("%.2f", cgpa)).append("\n");
        return builder.toString();
    }
}
