package com.tms.Lesson24.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {

    private DBService() {
    }

    public static synchronized Connection getConnection() {
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
            return null;
        }
    }
}
