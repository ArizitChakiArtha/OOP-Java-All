package bd.edu.aiub.oop.assignment.finalterm;

/**
 * AIUB-style letter grade and grade point.
 */
public enum LetterGrade {
    /** A plus grade. */ A_PLUS("A+", 4.00),
    /** A grade. */ A("A", 3.75),
    /** B plus grade. */ B_PLUS("B+", 3.50),
    /** B grade. */ B("B", 3.25),
    /** C plus grade. */ C_PLUS("C+", 3.00),
    /** C grade. */ C("C", 2.75),
    /** D grade. */ D("D", 1.00),
    /** F grade. */ F("F", 0.00);

    private final String label;
    private final double point;

    LetterGrade(String label, double point) {
        this.label = label;
        this.point = point;
    }

    /** @return grade label */
    public String getLabel() { return label; }

    /** @return grade point */
    public double getPoint() { return point; }
}
