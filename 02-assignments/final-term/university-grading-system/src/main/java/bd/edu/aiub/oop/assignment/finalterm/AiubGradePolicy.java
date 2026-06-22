package bd.edu.aiub.oop.assignment.finalterm;

/**
 * AIUB-like grade conversion policy.
 */
public class AiubGradePolicy implements GradePolicy {
    /**
     * Converts mark to grade.
     *
     * @param mark numeric mark
     * @return letter grade
     */
    @Override
    public LetterGrade resolve(double mark) {
        if (mark < 0 || mark > 100) throw new IllegalArgumentException("Mark must be 0 to 100.");
        if (mark >= 90) return LetterGrade.A_PLUS;
        if (mark >= 85) return LetterGrade.A;
        if (mark >= 80) return LetterGrade.B_PLUS;
        if (mark >= 75) return LetterGrade.B;
        if (mark >= 70) return LetterGrade.C_PLUS;
        if (mark >= 60) return LetterGrade.C;
        if (mark >= 50) return LetterGrade.D;
        return LetterGrade.F;
    }
}
