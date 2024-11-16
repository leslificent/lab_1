package controller;

import model.Group;
import model.Human;
import model.Sex;
import model.Student;

import java.util.List;

public class GroupCreator implements Creator<Group, Student> {
    private final StudentCreator studentCreator;

    public GroupCreator() {
        this.studentCreator = new StudentCreator();
    }

    @Override
    public Group create(String name, Human head, List<Student> students) {
        return new Group(name, head, students != null ? students : List.of());
    }

    public Student createStudent(String firstName, String lastName, String patronymic, Sex sex) {
        return studentCreator.create(firstName, lastName, patronymic, sex);
    }
}
