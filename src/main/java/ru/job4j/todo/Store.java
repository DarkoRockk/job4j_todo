package ru.job4j.todo;

import java.util.List;

public interface Store {

    List<Item> findAllItems();

    List<Item> findActiveItems();

    Item saveItem(Item item);

    Item updateItem(Item item);
}
