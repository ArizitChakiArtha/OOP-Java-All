package bd.edu.aiub.oop.lab05;

/**
 * Assessment contract.
 */
public interface Assessable {
    /**
     * Calculates final score.
     *
     * @param mid mid-term mark
     * @param finalExam final-term mark
     * @return final score
     */
    double calculateFinalScore(double mid, double finalExam);
}
