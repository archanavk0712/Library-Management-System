package com.library.servlets;

import com.library.dao.BookDAO;
import com.library.models.Book;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Book book = new Book(id, title, author, quantity);
        if (BookDAO.addBook(book)) {
            response.sendRedirect("admin.jsp?message=Book added successfully");
        } else {
            response.sendRedirect("addBook.jsp?error=Failed to add book");
        }
    }
}
