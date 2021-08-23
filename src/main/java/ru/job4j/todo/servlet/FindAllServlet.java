package ru.job4j.todo.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.todo.HbmStore;
import ru.job4j.todo.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindAllServlet extends HttpServlet {

    private static final Gson GSON = new GsonBuilder().create();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> list = HbmStore.instOf().findAllItems();
        Gson gson = new GsonBuilder().create();
        String jsonItems = gson.toJson(list);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.getWriter().write(jsonItems);
    }
}
