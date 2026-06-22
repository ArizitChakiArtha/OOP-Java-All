package bd.edu.aiub.oop.lab06;

/**
 * Demonstrates static and final modifiers.
 */
public class StaticFinalLab {
    /**
     * Runs static/final examples.
     *
     * @param args unused arguments
     */
    public static void main(String[] args) {
        String first = IdGenerator.nextId("student");
        String second = IdGenerator.nextId("student");
        AcademicRecord record = new AcademicRecord(first, 3.81);
        System.out.println(UniversityConstants.UNIVERSITY_NAME);
        System.out.println(first + ", " + second + ", sequence=" + IdGenerator.getSequence());
        System.out.println(record.getRecordId() + " eligible=" + record.isGraduationEligible());
    }
}
