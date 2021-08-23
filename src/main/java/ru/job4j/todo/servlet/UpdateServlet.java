package ru.job4j.todo.servlet;

import ru.job4j.todo.HbmStore;
import ru.job4j.todo.Item;
import ru.job4j.todo.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HbmStore.instOf().updateItem(Integer.parseInt(req.getParameter("id")));
    }
}
