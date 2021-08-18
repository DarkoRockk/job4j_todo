package ru.job4j.todo;

import ru.job4j.todo.servlet.FindAllServlet;

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
