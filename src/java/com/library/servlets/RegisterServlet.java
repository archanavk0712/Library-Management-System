package com.library.servlets;

import com.library.dao.UserDAO;
import com.library.models.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User newUser = new User(name, email, password, "user"); // ✅ Now this works!

        UserDAO userDAO = new UserDAO();
        boolean success = userDAO.registerUser(newUser);

        if (success) {
            response.sendRedirect("login.html?msg=Registered Successfully! Please Login.");
        } else {
            response.sendRedirect("register.jsp?error=Registration Failed");
        }
    }
}