package controller;


import model.Human;

import java.util.List;

public interface Creator<T, E> {
    // Метод для створення основних елементів, які підлягають управлінню
    T create(String name, Human head, List<E> subElements);
}