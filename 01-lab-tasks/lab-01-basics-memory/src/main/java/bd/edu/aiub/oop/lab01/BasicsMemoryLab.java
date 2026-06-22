package bd.edu.aiub.oop.lab01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Demonstrates Java basics, memory behavior, input validation, command-line arguments, and matrix operations.
 */
public class BasicsMemoryLab {
    /**
     * Runs all basic demonstrations.
     *
     * @param args optional command-line marks for average calculation
     */
    public static void main(String[] args) {
        demonstratePrimitiveAndReference();
        demonstrateCommandLineAverage(args);
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};
        printMatrix("Matrix addition", add(a, b));
        printMatrix("Matrix multiplication", multiply(a, b));
        printMatrix("Matrix transpose", transpose(a));
        runScannerValidationDemo();
    }

    /**
     * Shows that primitives copy values while arrays copy references.
     */
    public static void demonstratePrimitiveAndReference() {
        int original = 10;
        int copy = original;
        copy = 99;
        int[] numbers = {1, 2, 3};
        int[] alias = numbers;
        alias[0] = 50;
        int[] clone = Arrays.copyOf(numbers, numbers.length);
        clone[1] = 100;
        System.out.println("Primitive original=" + original + ", copy=" + copy);
        System.out.println("Reference original=" + Arrays.toString(numbers));
        System.out.println("Independent clone=" + Arrays.toString(clone));
    }

    /**
     * Calculates average from command-line marks.
     *
     * @param args mark list supplied through terminal
     */
    public static void demonstrateCommandLineAverage(String[] args) {
        if (args.length == 0) {
            System.out.println("Command-line average skipped because no marks were provided.");
            return;
        }
        double total = 0;
        for (String arg : args) {
            total += parseMark(arg);
        }
        System.out.printf("Command-line average: %.2f%n", total / args.length);
    }

    /**
     * Parses and validates a mark.
     *
     * @param value mark as text
     * @return valid integer mark
     */
    public static int parseMark(String value) {
        int mark = Integer.parseInt(value);
        if (mark < 0 || mark > 100) {
            throw new IllegalArgumentException("Mark must be from 0 to 100.");
        }
        return mark;
    }

    /**
     * Adds two equal-size matrices.
     *
     * @param first first matrix
     * @param second second matrix
     * @return sum matrix
     */
    public static int[][] add(int[][] first, int[][] second) {
        validateSameShape(first, second);
        int[][] result = new int[first.length][first[0].length];
        for (int row = 0; row < first.length; row++) {
            for (int col = 0; col < first[row].length; col++) {
                result[row][col] = first[row][col] + second[row][col];
            }
        }
        return result;
    }

    /**
     * Multiplies two compatible matrices.
     *
     * @param first first matrix
     * @param second second matrix
     * @return product matrix
     */
    public static int[][] multiply(int[][] first, int[][] second) {
        validateRectangular(first);
        validateRectangular(second);
        if (first[0].length != second.length) {
            throw new IllegalArgumentException("Matrix multiplication shape mismatch.");
        }
        int[][] result = new int[first.length][second[0].length];
        for (int row = 0; row < first.length; row++) {
            for (int col = 0; col < second[0].length; col++) {
                for (int k = 0; k < first[0].length; k++) {
                    result[row][col] += first[row][k] * second[k][col];
                }
            }
        }
        return result;
    }

    /**
     * Transposes a matrix.
     *
     * @param matrix source matrix
     * @return transposed matrix
     */
    public static int[][] transpose(int[][] matrix) {
        validateRectangular(matrix);
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                result[col][row] = matrix[row][col];
            }
        }
        return result;
    }

    /**
     * Prints a matrix.
     *
     * @param title output title
     * @param matrix matrix data
     */
    public static void printMatrix(String title, int[][] matrix) {
        System.out.println(title);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    /**
     * Demonstrates validated Scanner input using a non-blocking sample source.
     */
    public static void runScannerValidationDemo() {
        try (Scanner scanner = new Scanner("85\n")) {
            int mark = readInteger(scanner, "Enter mark: ", 0, 100);
            System.out.println("Validated scanner mark: " + mark);
        }
    }

    /**
     * Reads an integer safely from Scanner.
     *
     * @param scanner input scanner
     * @param prompt prompt text
     * @param min minimum value
     * @param max maximum value
     * @return validated integer
     */
    public static int readInteger(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNextInt()) {
                scanner.next();
                continue;
            }
            int value = scanner.nextInt();
            if (value >= min && value <= max) {
                return value;
            }
        }
    }

    private static void validateSameShape(int[][] first, int[][] second) {
        validateRectangular(first);
        validateRectangular(second);
        if (first.length != second.length || first[0].length != second[0].length) {
            throw new IllegalArgumentException("Matrices must have the same shape.");
        }
    }

    private static void validateRectangular(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Matrix cannot be empty.");
        }
        int length = matrix[0].length;
        for (int[] row : matrix) {
            if (row == null || row.length != length) {
                throw new IllegalArgumentException("Matrix must be rectangular.");
            }
        }
    }
}
