package bd.edu.aiub.oop.lab03;

/**
 * Demonstrates inheritance and super constructor calls.
 */
public class InheritanceLab {
    /**
     * Runs inheritance examples.
     *
     * @param args unused arguments
     */
    public static void main(String[] args) {
        Person person = new Person("P-1", "General Person", "person@aiub.edu");
        Employee employee = new Employee("E-1", "Admin Officer", "admin@aiub.edu", "Officer", 45000);
        Faculty faculty = new Faculty("F-1", "AIUB Faculty", "faculty@aiub.edu", 65000, "Lecturer", 4);
        System.out.println(person.describe());
        System.out.println(employee.describe());
        System.out.println(faculty.describe());
    }
}
