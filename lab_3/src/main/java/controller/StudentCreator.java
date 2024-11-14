package main.java.controller;
import main.java.model.Student;
import main.java.model.Sex;


public class StudentCreator {

    public StudentCreator() {
    }

    public Student create(String firstName, String lastName, String patronymic, Sex sex) {
        Student student = new Student(firstName, lastName, patronymic, sex);
        return student;
    }

}
