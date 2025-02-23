<%@ page import="java.util.List, com.library.models.Book" %>
<%@ page session="true" %>
<jsp:useBean id="bookDAO" class="com.library.dao.BookDAO" scope="application"/>
<%
    List<Book> books = bookDAO.getAllBooks();
%>
<!DOCTYPE html>
<html>
<head>
    <title>View Books</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url("images/view.jpg");
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            text-align: center;
            padding: 20px;
        }

        h2 {
            color: white;
            background-color: #3498db;
            padding: 15px;
            border-radius: 10px;
            display: inline-block;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background: #ffffff;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
            text-align: center;
        }

        th {
            background-color: #2c3e50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .remove-btn {
            padding: 8px 12px;
            font-size: 14px;
            font-weight: bold;
            color: white;
            background: #e74c3c;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: 0.3s;
        }

        .remove-btn:hover {
            background: #c0392b;
            transform: scale(1.05);
        }

        .back-btn {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            font-size: 16px;
            font-weight: bold;
            background-color: #2c3e50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: 0.3s;
        }

        .back-btn:hover {
            background-color: #1a252f;
            transform: scale(1.05);
        }

        .no-books {
            color: red;
            font-size: 18px;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h2>All Books</h2>

    <% if (books.isEmpty()) { %>
        <p class="no-books">No books available.</p>
    <% } else { %>
        <table>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Quantity</th>
                <th>Action</th> <!-- New Column for Remove Button -->
            </tr>
            <% for (Book book : books) { %>
            <tr>
                <td><%= book.getId() %></td>
                <td><%= book.getTitle() %></td>
                <td><%= book.getAuthor() %></td>
                <td><%= book.getQuantity() %></td>
                <td>
                    <form action="RemoveBookServlet" method="post" style="display:inline;">
                        <input type="hidden" name="bookId" value="<%= book.getId() %>">
                        <button type="submit" class="remove-btn">Remove</button>
                    </form>
                </td>
            </tr>
            <% } %>
        </table>
    <% } %>

    <!-- Button to go back to Admin Dashboard -->
    <button class="back-btn" onclick="window.location.href='admin.jsp'">Back to Admin Dashboard</button>

</body>
</html>
