package com.library.dao;

import com.library.models.Book;
import com.library.utils.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    // Method to get all books
    public static List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM books")) {
            while (rs.next()) {
                books.add(new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getInt("quantity")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    // Method to issue a book (reduce quantity by 1)
    public static boolean issueBook(int bookId) {
        try (Connection conn = DBConnection.getConnection()) {
            // Decrease the quantity of the book when issued
            String query = "UPDATE books SET quantity = quantity - 1 WHERE id = ? AND quantity > 0";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, bookId);
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0; // If rows are affected, the book was issued successfully
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Failed to issue the book
    }

    // Method to return a book (increase quantity by 1)
    public static boolean returnBook(int bookId) {
        try (Connection conn = DBConnection.getConnection()) {
            // Increase the quantity of the book when returned
            String query = "UPDATE books SET quantity = quantity + 1 WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, bookId);
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0; // If rows are affected, the book was returned successfully
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Failed to return the book
    }

    // Method to search books based on query (title, author, etc.)
    public static List<Book> searchBooks(String query) {
        List<Book> books = new ArrayList<>();
        String searchQuery = "SELECT * FROM books WHERE title LIKE ? OR author LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(searchQuery)) {
            stmt.setString(1, "%" + query + "%");
            stmt.setString(2, "%" + query + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    books.add(new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getInt("quantity")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    // Method to add a new book to the database
    public static boolean addBook(Book book) {
        String query = "INSERT INTO books (id, title, author, quantity) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, book.getId());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            stmt.setInt(4, book.getQuantity());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // If rows are affected, the book was added successfully
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Failed to add the book
    }
}
