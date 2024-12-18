package controller;

import model.Department;
import model.Faculty;
import model.Human;
import model.University;

import java.util.List;

public class UniversityCreator implements Creator<University, Faculty> {
    private final FacultyCreator facultyCreator;

    public UniversityCreator() {
        this.facultyCreator = new FacultyCreator();
    }

    @Override
    public University create(String name, Human head, List<Faculty> faculties) {
        return new University(name, head, faculties != null ? faculties : List.of());
    }

    public Faculty createFaculty(String name, Human head, List<Department> departments) {
        return facultyCreator.create(name, head, departments);
    }
}
