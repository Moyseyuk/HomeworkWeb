package com.tms;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CarsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter printWriter = resp.getWriter();

        String id = req.getParameter("id");
        if (id != null) {
            try {
                Connection connection = connectionToDatabase();
                int intId = Integer.parseInt(id.trim());
                PreparedStatement statement = connection.prepareStatement("select * from cars where id=?");
                statement.setInt(1, intId);
                ResultSet resultSet = statement.executeQuery();

                printWriter.println("Selected car: ");
                while (resultSet.next()) {
                    printWriter.println(resultSet.getString("model"));
                }
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Connection connection = connectionToDatabase();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select model from cars group by model");

                printWriter.println("List of all cars: ");
                while (resultSet.next()) {
                    printWriter.println(resultSet.getString("model"));
                }
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        setCookies(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter printWriter = resp.getWriter();

        String model = req.getParameter("model");
        String owner = req.getParameter("owner");
        String age = req.getParameter("age");

        try {
            Connection connection = connectionToDatabase();
            PreparedStatement statement = connection.prepareStatement("insert into cars (model, owner, age) values (?, ?, ?)");
            statement.setString(1, model);
            statement.setString(2, owner);
            int intAge = Integer.parseInt(age.trim());
            statement.setInt(3, intAge);
            statement.executeQuery();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        printWriter.println("Successfully insert");

        setCookies(resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String owner = req.getParameter("owner");
        if (id != null && owner != null) {
            try {
                Connection connection = connectionToDatabase();
                int intId = Integer.parseInt(id.trim());
                PreparedStatement statement = connection.prepareStatement(
                        "update cars set owner = ? where id = ?"
                );
                statement.setString(1, owner);
                statement.setInt(2, intId);
                statement.executeQuery();

                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        setCookies(resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));

        try {
            Connection connection = connectionToDatabase();
            PreparedStatement statement = connection.prepareStatement("delete from cars where id = ?");
            statement.setInt(1, id);
            statement.executeQuery();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        setCookies(resp);
    }

    protected Connection connectionToDatabase() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "3476"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void setCookies(HttpServletResponse resp) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH-mm");
        String time = LocalDateTime.now().format(formatter);

        Cookie cookie = new Cookie("time", time);
        cookie.setMaxAge(3600);
        resp.addCookie(cookie);
    }
}
