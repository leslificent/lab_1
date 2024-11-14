package model;

import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Objects;

@EqualsAndHashCode
public class Group {
    private String name;
    private Human head;
    private List<Student> students;

    public Group(String name, Human head, List<Student> students) {
        this.name = name;
        this.head = head;
        this.students = students;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public List<Student> getStudents() {
        return students;
    }

}

