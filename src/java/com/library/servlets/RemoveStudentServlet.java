package com.library.servlets;

import com.library.dao.StudentDAO;
import com.library.utils.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/RemoveStudentServlet")
public class RemoveStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");

        if (studentId == null || studentId.trim().isEmpty()) {
            response.sendRedirect("viewStudents.jsp?error=Invalid student ID");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM students WHERE student_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, studentId);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                response.sendRedirect("viewStudents.jsp?success=Student removed successfully");
            } else {
                response.sendRedirect("viewStudents.jsp?error=Failed to remove student");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("viewStudents.jsp?error=Database error: " + e.getMessage());
        }
    }
}
