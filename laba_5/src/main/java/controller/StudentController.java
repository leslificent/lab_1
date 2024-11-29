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
                    System.out.print("Enter a birthmonth (1-12): ");
                    getAndPrintStudentsByBirthMonth(scanner);
                    break;

                case 3:
                    System.out.println("The program is over...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Wrong choice. Try again.");
            }
        }
    }

    private static void printProgramStartupMessage() {
        System.out.println("Choose action:");
        System.out.println("1. Show all students");
        System.out.println("2. Show students by birthmonth");
        System.out.println("3. Over the program");
        System.out.print("Enter a number (1, 2, or 3): ");
    }

    private static void getAndPrintStudentsByBirthMonth(Scanner scanner) {
        int month = scanner.nextInt();
        if (month >= 1 && month <= 12) {
            List<StudentDTO> studentsByMonth = getStudentsByBirthday(month);
            printAllStudents(studentsByMonth);
            return;
        } else {
            System.out.println("Wrong number of month.");
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

