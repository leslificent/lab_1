package controller;



import model.Department;
import model.Faculty;
import model.Group;
import model.Human;

import java.util.List;

public class FacultyCreator implements Creator<Faculty, Department> {
    private final DepartmentCreator departmentCreator;

    public FacultyCreator() {
        this.departmentCreator = new DepartmentCreator(); // Створення контролера для кафедр
    }

    @Override
    public Faculty create(String name, Human head, List<Department> departments) {
        return new Faculty(name, head, departments != null ? departments : List.of());
    }

    // Можливість створення кафедри
    public Department createDepartment(String name, Human head, List<Group> groups) {
        return departmentCreator.create(name, head, groups); // Делегуємо створення кафедри нижчому рівню
    }
}
