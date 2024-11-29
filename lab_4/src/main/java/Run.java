import controller.*;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Run {
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

    public static void printUniversityDetails(University university){
        System.out.println("University: " + university.getName());
        System.out.println("The head of University: " + university.getHead());
        for (Faculty faculty : university.getFaculties()) {
            System.out.println("Faculty: " + faculty.getName());
            System.out.println("The head of Faculty: " + faculty.getHead());
            for (Department department : faculty.getDepartments()) {
                System.out.println("Department: " + department.getName());
                System.out.println("The head of Department: " + department.getHead());
                for (Group group : department.getGroups()) {
                    System.out.println("Group: " + group.getName());
                    System.out.println("The head of Group: " + group.getHead());
                }
            }
        }
    }

    public static void main(String[] args) {
        UniversityCreator universityCreator = new UniversityCreator();
        FacultyCreator facultyCreator = new FacultyCreator();
        DepartmentCreator departmentCreator = new DepartmentCreator();
        GroupCreator groupCreator = new GroupCreator();
        StudentCreator studentCreator = new StudentCreator();


        Group fitGroup1 = groupCreator.create("121-21-1", generateRandomHuman(), generateRandomStudents(20));
        Group fitGroup2 = groupCreator.create("121-21-2", generateRandomHuman(), generateRandomStudents(20));
        Group fitGroup3 = groupCreator.create("124-21-1", generateRandomHuman(), generateRandomStudents(20));
        Group fitGroup4 = groupCreator.create("124-21-1", generateRandomHuman(), generateRandomStudents(20));
        Group fitGroup5 = groupCreator.create("125-21-1", generateRandomHuman(), generateRandomStudents(20));
        Group fitGroup6 = groupCreator.create("125-21-1", generateRandomHuman(), generateRandomStudents(20));
        Group philGroup1 = groupCreator.create("073-21-1", generateRandomHuman(), generateRandomStudents(20));
        Group philGroup2 = groupCreator.create("073-21-1", generateRandomHuman(), generateRandomStudents(20));
        Group philGroup3 = groupCreator.create("035-21-1", generateRandomHuman(), generateRandomStudents(20));
        Group philGroup4 = groupCreator.create("035-21-1", generateRandomHuman(), generateRandomStudents(20));
        Group philGroup5 = groupCreator.create("033-21-1", generateRandomHuman(), generateRandomStudents(20));
        Group philGroup6 = groupCreator.create("033-21-1", generateRandomHuman(), generateRandomStudents(20));
        Group prtGroup1 = groupCreator.create("274-21-1", generateRandomHuman(), generateRandomStudents(20));
        Group prtGroup2 = groupCreator.create("274-21-1", generateRandomHuman(), generateRandomStudents(20));
        Group prtGroup3 = groupCreator.create("091-21-1", generateRandomHuman(), generateRandomStudents(20));
        Group prtGroup4 = groupCreator.create("091-21-1", generateRandomHuman(), generateRandomStudents(20));
        Group prtGroup5 = groupCreator.create("101-21-1", generateRandomHuman(), generateRandomStudents(20));
        Group prtGroup6 = groupCreator.create("101-21-1", generateRandomHuman(), generateRandomStudents(20));

        //List<Group> groups = List.of(fitGroup1, fitGroup2, fitGroup3,fitGroup4, fitGroup5, fitGroup6,
        //        philGroup1, philGroup2, philGroup3, philGroup4, philGroup5, philGroup6,
        //        prtGroup1, prtGroup2, prtGroup3, prtGroup4, prtGroup5, prtGroup6);

        Department ComputerScience = departmentCreator.create("Computer Science", generateRandomHuman(), List.of(fitGroup1, fitGroup2));
        Department SystemAnalysis = departmentCreator.create("System Analysis", generateRandomHuman(), List.of(fitGroup3, fitGroup4));
        Department Cybersecurity = departmentCreator.create("Cybersecurity", generateRandomHuman(), List.of(fitGroup5, fitGroup6));
        Department ForeignLanguages = departmentCreator.create("Foreign Languages", generateRandomHuman(), List.of(philGroup1, philGroup2));
        Department Translating = departmentCreator.create("Translating", generateRandomHuman(), List.of(philGroup3, philGroup4));
        Department Phylosophy = departmentCreator.create("Phylosophy", generateRandomHuman(), List.of(philGroup5, philGroup6));
        Department Geodesy = departmentCreator.create("Geodesy", generateRandomHuman(), List.of(prtGroup1, prtGroup2));
        Department Ecology = departmentCreator.create("Ecology", generateRandomHuman(), List.of(prtGroup3, prtGroup4));
        Department Biology = departmentCreator.create("Biology", generateRandomHuman(), List.of(prtGroup5, prtGroup6));

        //List<Department> departments = List.of(ComputerScience, SystemAnalysis, Cybersecurity,
        //        ForeignLanguages, Translating, Phylosophy, Geodesy, Ecology, Biology);

        Faculty FIT = facultyCreator.create("FIT", generateRandomHuman(), List.of(ComputerScience, SystemAnalysis, Cybersecurity));
        Faculty Philology = facultyCreator.create("Philology", generateRandomHuman(), List.of(ForeignLanguages, Translating, Phylosophy));
        Faculty NatureSciences = facultyCreator.create("Nature Sciences", generateRandomHuman(), List.of(Geodesy, Ecology, Biology));

        List<Faculty> faculties = List.of(FIT, Philology, NatureSciences);

        University university = universityCreator.create("Дніпровська політехніка", generateRandomHuman(), faculties);

        printUniversityDetails(university);

    }
}
