package controller;


import model.Department;
import model.Group;
import model.Human;
import model.Student;

import java.util.List;

public class DepartmentCreator implements Creator<Department, Group>{
    private final GroupCreator groupCreator;

    public DepartmentCreator() {
        this.groupCreator = new GroupCreator(); 
    }

    @Override
    public Department create(String name, Human head, List<Group> groups) {
        return new Department(name, head, groups != null ? groups : List.of());
    }

    public Group createGroup(String name, Human head, List<Student> students) {
        return groupCreator.create(name, head, students);
    }
}
