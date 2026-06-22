package bd.edu.aiub.oop.assignment.finalterm;

/**
 * Grade conversion contract.
 */
public interface GradePolicy {
    /**
     * Resolves a letter grade from a mark.
     *
     * @param mark numeric mark
     * @return letter grade
     */
    LetterGrade resolve(double mark);
}
