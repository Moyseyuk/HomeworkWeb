package com.tms.Lesson27.servlet;

import com.tms.Lesson27.CarsDBStore;
import com.tms.Lesson27.dto.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarsDBStore dbStore = CarsDBStore.getInstance();
        List<Car> cars = dbStore.getAll();
        req.setAttribute("cars", cars);
        req.getRequestDispatcher("/Lesson27/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carUUIDStr = req.getParameter("brand");
        UUID uuid = UUID.fromString(carUUIDStr);
        CarsDBStore dbStore = CarsDBStore.getInstance();
        Car carFromDb = dbStore.getAll().stream()
                .filter(car -> car.getUuid().equals(uuid))
                .findFirst().orElse(null);
        dbStore.delete(carFromDb);
        resp.sendRedirect("http://127.0.0.1:8080/HomeworkForWeb_war/home");
    }
}
