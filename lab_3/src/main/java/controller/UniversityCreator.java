package main.java.controller;
import main.java.model.Human;
import main.java.model.University;
import main.java.model.Faculty;
import main.java.model.Department;
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
