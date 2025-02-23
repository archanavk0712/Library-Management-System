package com.library.utils;

import java.sql.Connection;
import java.sql.Statement;

public class CreateTables {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            
            String createBooksTable = "CREATE TABLE books ("
                    + "id NUMBER PRIMARY KEY, "
                    + "title VARCHAR2(100), "
                    + "author VARCHAR2(100), "
                    + "quantity NUMBER)";
            stmt.executeUpdate(createBooksTable);

            String createStudentsTable = "CREATE TABLE students ("
                    + "id NUMBER PRIMARY KEY, "
                    + "name VARCHAR2(100), "
                    + "email VARCHAR2(100))";
            stmt.executeUpdate(createStudentsTable);

            System.out.println("Tables created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
