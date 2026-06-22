package bd.edu.aiub.oop.courseproject.model;

/**
 * Grade enum for CGPA calculation.
 */
public enum Grade {
    /** A plus grade. */ A_PLUS("A+", 4.00, 90),
    /** A grade. */ A("A", 3.75, 85),
    /** B plus grade. */ B_PLUS("B+", 3.50, 80),
    /** B grade. */ B("B", 3.25, 75),
    /** C plus grade. */ C_PLUS("C+", 3.00, 70),
    /** C grade. */ C("C", 2.75, 60),
    /** D grade. */ D("D", 1.00, 50),
    /** F grade. */ F("F", 0.00, 0);

    private final String label;
    private final double point;
    private final int minimum;

    Grade(String label, double point, int minimum) {
        this.label = label;
        this.point = point;
        this.minimum = minimum;
    }

    /** @return label */
    public String getLabel() { return label; }

    /** @return point */
    public double getPoint() { return point; }

    /**
     * Resolves mark to grade.
     *
     * @param mark numeric mark
     * @return grade
     */
    public static Grade fromMark(double mark) {
        for (Grade grade : values()) {
            if (mark >= grade.minimum) return grade;
        }
        return F;
    }
}
