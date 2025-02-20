package com.library.servlets;

import com.library.dao.UserDAO;
import com.library.models.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        // **Hardcoded Admin Login**
        if ("admin@library.com".equals(email) && "admin123".equals(password)) {
            User adminUser = new User(0, "Admin", email, password, "admin");
            session.setAttribute("user", adminUser);
            session.setAttribute("userRole", "admin"); // ✅ Added
            response.sendRedirect("admin.jsp");
            return;
        }

        // **Database Check for Users**
        UserDAO userDAO = new UserDAO();
        User user = userDAO.validateUser(email, password);

        if (user != null) {
    System.out.println("User Found: " + user.getEmail() + " | Role: " + user.getRole()); // ✅ Debugging Log
    session.setAttribute("user", user);
    session.setAttribute("userRole", user.getRole()); 

    if ("admin".equals(user.getRole())) {
        response.sendRedirect("admin.jsp");
    } else {
        response.sendRedirect("student.jsp");
    }
} else {
    System.out.println("User Not Found: " + email); // ❌ Debugging Log
    response.sendRedirect("login.html?error=Invalid Email or Password");
}
 }   
  

}
