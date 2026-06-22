package bd.edu.aiub.oop.lab05;

/**
 * Demonstrates abstract classes and multiple interface implementation.
 */
public class AbstractionLab {
    /**
     * Runs abstraction examples.
     *
     * @param args unused arguments
     */
    public static void main(String[] args) {
        Course[] courses = {
            new OnlineCourse("CSC2210", "Object-Oriented Programming", 3, "https://virtual.aiub.edu/oop"),
            new OfflineCourse("CSC1204", "Programming Language I", 3, "D-0508")
        };
        for (Course course : courses) {
            System.out.println(course.describe());
            System.out.println(course.registerStudent("22-49234-3"));
            System.out.println(course.calculateFinalScore(86, 92));
        }
    }
}
