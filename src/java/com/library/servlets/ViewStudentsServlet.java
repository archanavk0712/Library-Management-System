package com.library.servlets;

import com.library.dao.StudentDAO;
import com.library.models.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ViewStudentsServlet")
public class ViewStudentsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ✅ Corrected the way getAllStudents() is called
        StudentDAO studentDAO = new StudentDAO();
        List<Student> students = (List<Student>) studentDAO.getAllStudents();

        // ✅ Check if the list is null to prevent NullPointerException
        if (students == null) {
            students = new ArrayList<>();
        }

        request.setAttribute("students", students);
        request.getRequestDispatcher("viewStudents.jsp").forward(request, response);
    }
}
