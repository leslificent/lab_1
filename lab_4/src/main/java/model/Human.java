package model;

import lombok.EqualsAndHashCode;

import java.util.Objects;

@EqualsAndHashCode
public class Human {
    protected String firstName;
    protected String lastName;
    protected String patronymic;
    protected Sex sex;

    public Human(String firstName, String lastName, String patronymic, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.sex = sex;
    }

    public String getFullName() {
        return firstName + " " + lastName + " " + patronymic;
    }

    public Sex getSex() {
        return sex;
    }

}
