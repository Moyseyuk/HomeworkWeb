package com.tms.Lesson24.services;

import com.tms.Lesson24.dao.DBService;

import java.sql.*;

public class LoginService {

    public static String accessFilter(String login, String password){
        Connection connection = DBService.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select password, role from users where login = ?");
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("password").equals(password)) {
                    if (resultSet.getString("role").equals("admin")) {
                        return "admin";
                    } else if (resultSet.getString("role").equals("user")) {
                        return "user";
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "error";
    }
}
