package main.java.model;
import java.util.List;

public class University {
    private String name;
    private Human head;
    private List<Faculty> faculties;

    public University(String name, Human head, List<Faculty> faculties) {
        this.name = name;
        this.head = head;
        this.faculties = faculties;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }
}
