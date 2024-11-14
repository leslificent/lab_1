package model;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Student extends Human {
    private Group group;

    public Student(String firstName, String lastName, String patronymic, Sex sex) {
        super(firstName, lastName, patronymic, sex);
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

}
