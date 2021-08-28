package ru.job4j.todo.servlet;

import ru.job4j.todo.model.User;
import ru.job4j.todo.store.HbmStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession sc = req.getSession();
        User user = HbmStore.instOf().findUserByEmail(email);
        if (user == null || !user.getPassword().equals(password)) {
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("Неверный логин или пароль");
        } else {
            sc.setAttribute("user", user);
        }

    }
}
