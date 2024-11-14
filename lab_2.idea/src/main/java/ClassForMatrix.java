package main.java;

import java.util.Random;
import java.util.Scanner;

public class ClassForMatrix {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 2323;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість рядків матриці (max 20): ");
        int rows = scanner.nextInt();
        System.out.print("Введіть кількість стовпців матриці (max 20): ");
        int cols = scanner.nextInt();

        if (rows > 20 || cols > 20) {
            System.out.println("Максимальний розмір матриці 20x20.");
            return;
        }

        int[][] matrix = new int[rows][cols];

        System.out.print("Виберіть спосіб заповнення матриці (1 - вручну, 2 - випадкові числа): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            fillMatrixManually(matrix, scanner);
        } else if (choice == 2) {
            fillMatrixRandomly(matrix);
        } else {
            System.out.println("Невірний вибір.");
            return;
        }

        System.out.println("Ваша матриця:");
        printMatrix(matrix);

        int min = findMin(matrix);
        int max = findMax(matrix);
        double average = calculateArithmeticMean(matrix);
        double geometricMean = calculateGeometricMean(matrix);

        System.out.println("Мінімальне значення: " + min);
        System.out.println("Максимальне значення: " + max);
        System.out.println("Середнє арифметичне: " + average);
        System.out.println("Середнє геометричне: " + geometricMean);
    }

    public static void fillMatrixManually(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Введіть елемент [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public static void fillMatrixRandomly(int[][] matrix) {
        Random rand = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rand.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }

    public static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt < min) {
                    min = anInt;
                }
            }
        }
        return min;
    }

    public static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt > max) {
                    max = anInt;
                }
            }
        }
        return max;
    }

    public static double calculateArithmeticMean(int[][] matrix) {
        double sum = 0;
        int count = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                sum += anInt;
                count++;
            }
        }
        return sum / count;
    }

    public static double calculateGeometricMean(int[][] matrix) {
        double product = 1;
        int count = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                product *= anInt;
                count++;
            }
        }
        return Math.pow(product, 1.0 / count);
    }
}
