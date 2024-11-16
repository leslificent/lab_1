package controller;


import model.Human;

import java.util.List;

public interface Creator<T, E> {
    T create(String name, Human head, List<E> subElements);
}
