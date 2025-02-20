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
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>All Books</h2>
    <table>
        <tr><th>ID</th><th>Title</th><th>Author</th><th>Quantity</th></tr>
        <% for (Book book : books) { %>
        <tr>
            <td><%= book.getId() %></td>
            <td><%= book.getTitle() %></td>
            <td><%= book.getAuthor() %></td>
            <td><%= book.getQuantity() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
