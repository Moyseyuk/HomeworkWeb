package com.tms.Lesson24.services;

import com.tms.Lesson24.dao.DBService;

import java.sql.*;

public class RegisterUserService {

    public static synchronized String addUser(String login, String password, String sex, String description, String role){
        Connection connection = DBService.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select login from users where login = ?");
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return "error";
            } else {
                PreparedStatement stmt = connection.prepareStatement(
                        "insert into users (login, password, sex, description, role) values (?, ?, ?, ?, ?)"
                );
                stmt.setString(1, login);
                stmt.setString(2, password);
                stmt.setString(3, sex);
                stmt.setString(4, description);
                stmt.setString(5, role);
                stmt.executeUpdate();
                stmt.close();
                return "saved";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
