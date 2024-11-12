package main.java.controller;

import main.java.model.*;

import java.util.List;

public class DepartmentCreator implements Creator<Department, Group>{
    private final GroupCreator groupCreator;

    public DepartmentCreator() {
        this.groupCreator = new GroupCreator(); // Створення контролера для кафедр
    }

    @Override
    public Department create(String name, Human head, List<Group> groups) {
        return new Department(name, head, groups != null ? groups : List.of());
    }

    // Можливість створення кафедри
    public Group createGroup(String name, Human head, List<Student> students) {
        return groupCreator.create(name, head, students);
    }
}
