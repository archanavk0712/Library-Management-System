package com.library.servlets;

import com.library.dao.StudentDAO;
import com.library.models.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form parameters
        String studentId = request.getParameter("studentId");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String book = request.getParameter("book");   // New Attribute
        String author = request.getParameter("author"); // New Attribute

        // Create Student object
        Student student = new Student(studentId, name, email, book, author);

        // Insert into database
        StudentDAO studentDAO = new StudentDAO();
        boolean success = studentDAO.addStudent(student);

        if (success) {
            response.sendRedirect("viewStudents.jsp?status=success");
        } else {
            response.sendRedirect("addStudent.jsp?status=error");
        }
    }
}
