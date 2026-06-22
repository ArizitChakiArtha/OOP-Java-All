package bd.edu.aiub.oop.assignment.finalterm;

import java.util.ArrayList;
import java.util.List;

/**
 * Grading service for CGPA calculation.
 */
public class GradingService {
    private final List<Registration> registrations = new ArrayList<>();

    /**
     * Adds a registration.
     *
     * @param registration registration to add
     */
    public void addRegistration(Registration registration) {
        if (registration == null) throw new IllegalArgumentException("Registration required.");
        registrations.add(registration);
    }

    /**
     * Calculates CGPA by student ID.
     *
     * @param studentId student ID
     * @return calculated CGPA
     */
    public double calculateCgpa(String studentId) {
        double total = 0;
        int credits = 0;
        for (Registration registration : registrations) {
            if (registration.getStudent().getId().equals(studentId)) {
                total += registration.getWeightedPoint();
                credits += registration.getCourse().getCredit();
            }
        }
        return credits == 0 ? 0 : total / credits;
    }

    /**
     * Lists all registrations.
     *
     * @return defensive list
     */
    public List<Registration> getRegistrations() { return new ArrayList<>(registrations); }
}
