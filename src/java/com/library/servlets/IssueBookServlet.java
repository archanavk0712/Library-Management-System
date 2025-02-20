package com.library.servlets;

import com.library.dao.BookDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/IssueBookServlet")
public class IssueBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));

        if (BookDAO.issueBook(bookId)) {
            response.sendRedirect("viewBooks.jsp?message=Book issued successfully");
        } else {
            response.sendRedirect("issueBook.jsp?error=Failed to issue book");
        }
    }
}
