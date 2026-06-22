package bd.edu.aiub.oop.assignment.finalterm;

/**
 * Runs the final-term University Grading System assignment.
 */
public class UniversityGradingApp {
    /**
     * Executes grading system.
     *
     * @param args unused arguments
     */
    public static void main(String[] args) {
        GradePolicy policy = new AiubGradePolicy();
        Student student = new Student("22-49234-3", "Koushik Biswas Arko");
        Course oop = new Course("CSC2210", "Object-Oriented Programming", 3);
        Course database = new Course("CSC3308", "Database Management", 3);
        GradingService service = new GradingService();
        service.addRegistration(new Registration(student, oop, 94, policy));
        service.addRegistration(new Registration(student, database, 88, policy));
        for (Registration registration : service.getRegistrations()) {
            System.out.println(registration.getCourse().getCode() + " | " + registration.getMark() + " | " + registration.getGrade().getLabel());
        }
        System.out.printf("CGPA: %.2f%n", service.calculateCgpa(student.getId()));
    }
}
