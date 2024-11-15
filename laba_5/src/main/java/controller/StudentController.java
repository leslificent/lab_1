package controller;

import db.StudentsDatabase;
import db.dto.StudentDTO;

import java.util.List;
import java.util.Scanner;

public class StudentController {
    static StudentsDatabase studentsDatabase = new StudentsDatabase();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printProgramStartupMessage();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    List<StudentDTO> allStudents = getAllStudents();
                    printAllStudents(allStudents);
                    break;

                case 2:
                    System.out.print("Введіть номер місяця народження (1-12): ");
                    getAndPrintStudentsByBirthMonth(scanner);
                    break;

                case 3:
                    System.out.println("Завершення роботи програми...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }

    private static void printProgramStartupMessage() {
        System.out.println("Оберіть дію:");
        System.out.println("1. Вивести всіх студентів");
        System.out.println("2. Вивести студентів по місяцю народження");
        System.out.println("3. Завершити роботу програми");
        System.out.print("Введіть цифру (1, 2, або 3): ");
    }

    private static void getAndPrintStudentsByBirthMonth(Scanner scanner) {
        int month = scanner.nextInt();
        if (month >= 1 && month <= 12) {
            List<StudentDTO> studentsByMonth = getStudentsByBirthday(month);
            printAllStudents(studentsByMonth);
            return;
        } else {
            System.out.println("Невірний номер місяця.");
        }
    }

    private static List<StudentDTO> getAllStudents() {
        return studentsDatabase.getStudentsFromDatabase();
    }

    private static void printAllStudents(List<StudentDTO> students) {
        for (StudentDTO student : students) {
            System.out.println(student);
        }
    }

    private static List<StudentDTO> getStudentsByBirthday(int month) {
        List<StudentDTO> studentDTOS = getAllStudents();

        return studentDTOS.stream()
                .filter(studentDTO -> studentDTO.getBirthDate().getMonth() + 1 == month)
                .toList();
    }

}

