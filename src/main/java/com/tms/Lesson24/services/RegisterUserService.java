package com.tms.Lesson24.services;

import com.tms.Lesson24.dao.DBService;

import java.sql.*;

public class RegisterUserService {

    public static synchronized String addUser(String login, String password, String sex, String description, String role){
        Connection connection = DBService.getConnection();
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
                return "error";
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
        return "saved";
    }
}
