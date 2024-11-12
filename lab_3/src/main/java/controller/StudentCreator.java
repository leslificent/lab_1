package main.java.controller;


import main.java.model.Group;
import main.java.model.Sex;
import main.java.model.Student;


public class StudentCreator {

    public StudentCreator() {
    }

    public Student create(String firstName, String lastName, String patronymic, Sex sex) {
        Student student = new Student(firstName, lastName, patronymic, sex);
        return student;
    }

}
