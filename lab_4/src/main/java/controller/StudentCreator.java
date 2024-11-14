package controller;


import model.Sex;
import model.Student;

public class StudentCreator {

    public StudentCreator() {
    }

    public Student create(String firstName, String lastName, String patronymic, Sex sex) {
        Student student = new Student(firstName, lastName, patronymic, sex);
        return student;
    }

}
