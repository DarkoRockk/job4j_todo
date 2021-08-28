package ru.job4j.todo.servlet;

import ru.job4j.todo.model.User;
import ru.job4j.todo.store.HbmStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = HbmStore.instOf().findUserByEmail(email);
        if (user != null) {
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("Данная почта уже существует");
        } else {
            HttpSession sc = req.getSession();
            User usr = new User();
            usr.setName(name);
            usr.setEmail(email);
            usr.setPassword(password);
            HbmStore.instOf().saveUser(usr);
            sc.setAttribute("user", usr);
        }
    }
}
