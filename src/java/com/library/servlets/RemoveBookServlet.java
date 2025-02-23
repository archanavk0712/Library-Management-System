package com.library.servlets;

import com.library.dao.BookDAO;
import com.library.utils.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/RemoveBookServlet")
public class RemoveBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("bookId");

        if (bookId == null || bookId.trim().isEmpty()) {
            response.sendRedirect("viewBooks.jsp?error=Invalid book ID");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM books WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(bookId));

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                response.sendRedirect("viewBooks.jsp?success=Book removed successfully");
            } else {
                response.sendRedirect("viewBooks.jsp?error=Failed to remove book");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("viewBooks.jsp?error=Database error: " + e.getMessage());
        }
    }
}
