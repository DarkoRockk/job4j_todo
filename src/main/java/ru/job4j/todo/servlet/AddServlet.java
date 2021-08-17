package ru.job4j.todo.servlet;

import ru.job4j.todo.HbmStore;
import ru.job4j.todo.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String description = req.getParameter("description");

        Item item = new Item(description);
        HbmStore.instOf().saveItem(item);

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }
}