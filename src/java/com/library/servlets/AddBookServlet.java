package com.library.servlets;

import com.library.utils.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String quantityStr = request.getParameter("quantity"); // Get quantity as string

        // ✅ Fix: Ensure quantity is not null or empty before parsing
        int quantity = 0;
        if (quantityStr != null && !quantityStr.trim().isEmpty()) {
            try {
                quantity = Integer.parseInt(quantityStr);
            } catch (NumberFormatException e) {
                response.sendRedirect("addBook.jsp?error=Invalid quantity. Please enter a valid number.");
                return;
            }
        } else {
            response.sendRedirect("addBook.jsp?error=Quantity cannot be empty.");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            // ✅ Step 1: Check if student already exists
            String checkStudentSQL = "SELECT COUNT(*) FROM students WHERE name = ?";
            PreparedStatement checkPs = conn.prepareStatement(checkStudentSQL);
            checkPs.setString(1, title); // Assuming the title represents the student name
            ResultSet rs = checkPs.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                response.sendRedirect("addBook.jsp?error=Student already exists.");
                return;
            }

            // ✅ Step 2: Insert the book if the student does not exist
            String sql = "INSERT INTO books (title, author, quantity) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, quantity);

            int rowsAffected = ps.executeUpdate();
            conn.commit();

            if (rowsAffected > 0) {
                response.sendRedirect("viewBooks.jsp?success=Book added successfully");
            } else {
                response.sendRedirect("addBook.jsp?error=Failed to add book.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("addBook.jsp?error=Database error: " + e.getMessage());
        }
    }
}
