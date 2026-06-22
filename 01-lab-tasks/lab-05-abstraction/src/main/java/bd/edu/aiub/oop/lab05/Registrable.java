package bd.edu.aiub.oop.lab05;

/**
 * Registration contract.
 */
public interface Registrable {
    /**
     * Registers a student.
     *
     * @param studentId student ID
     * @return confirmation
     */
    String registerStudent(String studentId);
}
