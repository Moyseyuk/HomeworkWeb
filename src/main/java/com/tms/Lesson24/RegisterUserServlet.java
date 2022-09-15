package com.tms.Lesson24;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String description = req.getParameter("description");
        String role = req.getParameter("role");

        Connection connection = connectionToDatabase();
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select login from users");
            boolean exist = false;

            while (resultSet.next()) {
                if (resultSet.getString("login").equals(login)) {
                    exist = true;
                }
            }
            if (exist) {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ErrorPage.html");
                requestDispatcher.forward(req, resp);
            } else {
                PreparedStatement statement = connection.prepareStatement(
                        "insert into users (login, password, sex, description, role) values (?, ?, ?, ?, ?)"
                );
                statement.setString(1, login);
                statement.setString(2, password);
                statement.setString(3, sex);
                statement.setString(4, description);
                statement.setString(5, role);
                statement.executeUpdate();
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
}
