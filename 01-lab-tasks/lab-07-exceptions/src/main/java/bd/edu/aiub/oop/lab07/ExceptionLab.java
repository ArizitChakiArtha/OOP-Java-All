package bd.edu.aiub.oop.lab07;

/**
 * Demonstrates try-catch-finally, throw, throws, and custom checked exceptions.
 */
public class ExceptionLab {
    /**
     * Runs exception handling demonstration.
     *
     * @param args unused arguments
     */
    public static void main(String[] args) {
        try {
            StudentRecord record = createRecord("22-49234-3", 3.81, 148);
            record.validateGraduation();
            System.out.println("Graduation validation successful for " + record.getStudentId());
        } catch (InvalidCgpaException | EnrollmentException exception) {
            System.out.println("Validation failed: " + exception.getMessage());
        } finally {
            System.out.println("Finally block executed.");
        }
    }

    /**
     * Creates a record and propagates checked exceptions.
     *
     * @param id student ID
     * @param cgpa CGPA
     * @param credits completed credits
     * @return student record
     * @throws InvalidCgpaException when CGPA is invalid
     * @throws EnrollmentException when credits are invalid
     */
    public static StudentRecord createRecord(String id, double cgpa, int credits) throws InvalidCgpaException, EnrollmentException {
        return new StudentRecord(id, cgpa, credits);
    }
}
