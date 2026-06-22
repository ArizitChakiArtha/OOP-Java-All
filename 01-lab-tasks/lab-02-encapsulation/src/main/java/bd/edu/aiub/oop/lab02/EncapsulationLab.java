package bd.edu.aiub.oop.lab02;

/**
 * Demonstrates encapsulation, validation, overloaded constructors, and this() chaining.
 */
public class EncapsulationLab {
    /**
     * Runs the encapsulation demo.
     *
     * @param args unused arguments
     */
    public static void main(String[] args) {
        Student first = new Student();
        Student second = new Student("22-49234-3", "Koushik Biswas Arko", "CSE", 3.81);
        System.out.println(first.describe());
        System.out.println(second.describe());
    }
}
