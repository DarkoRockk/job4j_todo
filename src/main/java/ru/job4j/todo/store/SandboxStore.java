package ru.job4j.todo.store;

import ru.job4j.todo.model.Item;
import ru.job4j.todo.store.HbmStore;
import ru.job4j.todo.store.Store;

public class SandboxStore {

    public static void main(String[] args) {
        Store store = HbmStore.instOf();
        Item item = new Item("Тестовое описание");

        store.saveItem(item);

        for (Item it : store.findAllItems()) {
            System.out.println(it);
        }

    }
}