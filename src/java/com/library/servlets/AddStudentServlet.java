package com.library.servlets;

import com.library.dao.StudentDAO;
import com.library.models.Student;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Retrieve form data
        String studentId = request.getParameter("studentId");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String bookName = request.getParameter("bookName");
        String author = request.getParameter("author");

        // Create Student object
        Student student = new Student(studentId, name, email, bookName, author);

        // Instantiate StudentDAO
        StudentDAO studentDAO = new StudentDAO();

        // ✅ Step 1: Check if student already exists by Student ID or Email
        if (studentDAO.studentExists(studentId, email)) {
            response.sendRedirect("addStudent.jsp?error=Student already exists.");
            return;
        }

        // ✅ Step 2: Insert student if not found
        boolean success = studentDAO.addStudent(student);

        if (success) {
            response.sendRedirect("viewStudents.jsp?success=Student added successfully");
        } else {
            response.sendRedirect("addStudent.jsp?error=Failed to add student");
        }
    }
}
