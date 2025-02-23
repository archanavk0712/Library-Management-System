package com.library.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() throws SQLException {
        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.OracleDriver");
            // Database URL
            String url = "jdbc:oracle:thin:@localhost:1521:XE"; // Update this based on your DB settings
            // Database credentials
            String user = "system";
            String password = "admin@123";
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new SQLException("Connection to DB failed");
        }
    }
}
