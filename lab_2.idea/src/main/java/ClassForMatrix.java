package main.java;

import java.util.Random;
import java.util.Scanner;

public class ClassForMatrix {

    // Константи для генерації випадкових чисел
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 2323;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення розмірів матриці
        System.out.print("Введіть кількість рядків матриці (max 20): ");
        int rows = scanner.nextInt();
        System.out.print("Введіть кількість стовпців матриці (max 20): ");
        int cols = scanner.nextInt();

        // Перевірка на максимальний розмір
        if (rows > 20 || cols > 20) {
            System.out.println("Максимальний розмір матриці 20x20.");
            return;
        }

        // Створення матриці
        int[][] matrix = new int[rows][cols];

        // Вибір способу заповнення матриці
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

        // Виведення матриці
        System.out.println("Ваша матриця:");
        printMatrix(matrix);

        // Операції з матрицею
        int min = findMin(matrix);
        int max = findMax(matrix);
        double average = calculateArithmeticMean(matrix);
        double geometricMean = calculateGeometricMean(matrix);

        // Виведення результатів
        System.out.println("Мінімальне значення: " + min);
        System.out.println("Максимальне значення: " + max);
        System.out.println("Середнє арифметичне: " + average);
        System.out.println("Середнє геометричне: " + geometricMean);
    }

    // Заповнення матриці вручну
    public static void fillMatrixManually(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Введіть елемент [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    // Заповнення матриці випадковими числами
    public static void fillMatrixRandomly(int[][] matrix) {
        Random rand = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rand.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
            }
        }
    }

    // Виведення матриці
    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }

    // Пошук мінімального елемента
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

    // Розрахунок середнього арифметичного
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

    // Розрахунок середнього геометричного
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
