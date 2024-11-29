package org.example;


import controller.*;
import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    @Test
    public void testUniversitySerialization() throws IOException {
        UniversityCreator universityCreator = new UniversityCreator();
        FacultyCreator facultyCreator = new FacultyCreator();
        DepartmentCreator departmentCreator = new DepartmentCreator();
        GroupCreator groupCreator = new GroupCreator();


        Group group1 = groupCreator.create("121-21-1", generateRandomHuman(), generateRandomStudents(2));
        Group group2 = groupCreator.create("121-21-2", generateRandomHuman(), generateRandomStudents(2));
        Group group3 = groupCreator.create("124-21-1", generateRandomHuman(), generateRandomStudents(2));
        Group group4 = groupCreator.create("124-21-2", generateRandomHuman(), generateRandomStudents(2));
        Group group5 = groupCreator.create("073-21-1", generateRandomHuman(), generateRandomStudents(2));
        Group group6 = groupCreator.create("073-21-2", generateRandomHuman(), generateRandomStudents(2));
        Group group7 = groupCreator.create("035-21-1", generateRandomHuman(), generateRandomStudents(2));
        Group group8 = groupCreator.create("035-21-2", generateRandomHuman(), generateRandomStudents(2));

        Department department1 = departmentCreator.create("Computer Science", generateRandomHuman(), List.of(group1, group2));
        Department department2 = departmentCreator.create("System Analysis", generateRandomHuman(), List.of(group3, group4));
        Department department3 = departmentCreator.create("Foreign Languages", generateRandomHuman(), List.of(group5, group6));
        Department department4 = departmentCreator.create("Translating", generateRandomHuman(), List.of(group7, group8));

        Faculty faculty1 = facultyCreator.create("FIT", generateRandomHuman(), List.of(department1, department2));
        Faculty faculty2 = facultyCreator.create("Philology", generateRandomHuman(), List.of(department3, department4));

        University oldUniversity = universityCreator.create("NTU DP", generateRandomHuman(), List.of(faculty1, faculty2));

        String filePath = "university.json";
        JsonManager.saveUniversityToJson(oldUniversity, filePath);

        University newUniversity = JsonManager.loadUniversityFromJson(filePath);

        assertEquals(oldUniversity, newUniversity, "The universities should be equivalent");
    }

    public static Human generateRandomHuman() {
        Random random = new Random();

        String[] firstNames = {"Alex", "John", "Mary", "Hanna", "Peter", "Kate"};
        String[] lastNames = {"Macminamen", "Rurk", "Smith", "Bolchiko", "Limon", "Polombok"};
        String[] middleNames = {"Victorovich", "Petrovich", "Olexandrivna", "Ivanivna", "Cerhiivna", "Andriivna"};
        
        String firstName = firstNames[random.nextInt(firstNames.length)];
        String lastName = lastNames[random.nextInt(lastNames.length)];
        String middleName = middleNames[random.nextInt(middleNames.length)];
        Sex gender = random.nextBoolean() ? Sex.MALE : Sex.FEMALE;

        return new Human(firstName, lastName, middleName, gender);
    }

    public static List<Student> generateRandomStudents(int count) {
        List<Student> students = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            String firstName = "Name" + i;
            String lastName = "Surname" + i;
            String middleName = "Middle" + i;
            Sex gender = random.nextBoolean() ? Sex.MALE : Sex.FEMALE;

            Student student = new Student(firstName, lastName, middleName, gender);
            students.add(student);
        }

        return students;
    }
}
