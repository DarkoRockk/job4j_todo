package ru.job4j.todo.store;

import ru.job4j.todo.model.Item;
import ru.job4j.todo.model.User;

import java.util.List;

public interface Store {

    List<Item> findAllItems();

    List<Item> findActiveItems();

    Item saveItem(Item item);

    User saveUser(User user);

    void updateItem(int id);

    User findUserByEmail(String email);
}
