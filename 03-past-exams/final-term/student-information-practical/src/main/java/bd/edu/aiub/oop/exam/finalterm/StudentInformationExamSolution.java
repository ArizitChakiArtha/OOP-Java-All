package bd.edu.aiub.oop.exam.finalterm;

/**
 * Runs the final-term student information practical solution.
 */
public class StudentInformationExamSolution {
    /**
     * Executes final practical solution.
     *
     * @param args unused arguments
     */
    public static void main(String[] args) {
        StudentInformationSystem system = new StudentInformationSystem();
        system.addStudent(new Student("22-49234-3", "Koushik Biswas Arko", "CSE"));
        system.addFaculty(new Faculty("F-101", "AIUB Faculty", "Lecturer"));
        system.addResult(new Result("22-49234-3", "CSC2210", 94));
        system.addResult(new Result("22-49234-3", "CSC3308", 88));
        system.printReport();
    }
}
