package bd.edu.aiub.oop.courseproject.util;

import java.util.Scanner;

/**
 * Provides safe console input reading.
 */
public class InputHelper {
    private final Scanner scanner;

    /**
     * Creates input helper.
     *
     * @param scanner scanner instance
     */
    public InputHelper(Scanner scanner) {
        if (scanner == null) throw new IllegalArgumentException("Scanner required.");
        this.scanner = scanner;
    }

    /**
     * Reads non-empty text.
     *
     * @param prompt prompt message
     * @return validated text
     */
    public String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) return value;
            System.out.println("Input cannot be empty.");
        }
    }

    /**
     * Reads integer in range.
     *
     * @param prompt prompt message
     * @param min minimum value
     * @param max maximum value
     * @return validated integer
     */
    public int readInt(String prompt, int min, int max) {
        while (true) {
            try {
                int value = Integer.parseInt(readText(prompt));
                if (value >= min && value <= max) return value;
                System.out.println("Value must be from " + min + " to " + max + ".");
            } catch (NumberFormatException exception) {
                System.out.println("Enter a valid integer.");
            }
        }
    }

    /**
     * Reads double in range.
     *
     * @param prompt prompt message
     * @param min minimum value
     * @param max maximum value
     * @return validated double
     */
    public double readDouble(String prompt, double min, double max) {
        while (true) {
            try {
                double value = Double.parseDouble(readText(prompt));
                if (value >= min && value <= max) return value;
                System.out.println("Value must be from " + min + " to " + max + ".");
            } catch (NumberFormatException exception) {
                System.out.println("Enter a valid number.");
            }
        }
    }
}
