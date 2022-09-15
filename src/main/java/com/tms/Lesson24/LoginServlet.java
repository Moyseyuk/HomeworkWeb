package com.tms.Lesson24;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Connection connection = connectionToDatabase();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select login, password, role from users");
            while (resultSet.next()) {
                if (resultSet.getString("login").equals(login)
                        && resultSet.getString("password").equals(password)) {
                    if (resultSet.getString("role").equals("admin")) {
                        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/AddUser.html");
                        requestDispatcher.forward(req, resp);
                    } else if (resultSet.getString("role").equals("user")) {
                        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ShowImage.html");
                        requestDispatcher.forward(req, resp);
                    }
                }
            }
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ErrorPage.html");
            requestDispatcher.forward(req, resp);
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
