<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <title>Search Book</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <form action="SearchServlet" method="post">
        <h2>Search for a Book</h2>
        <input type="text" name="query" placeholder="Enter title or author" required>
        <button type="submit">Search</button>
    </form>

    <h2>Search Results:</h2>
    <ul>
        <% 
            List<com.library.models.Book> books = (List<com.library.models.Book>) session.getAttribute("searchResults");
            if (books != null) {
                for (com.library.models.Book book : books) {
        %>
            <li><%= book.getTitle() %> by <%= book.getAuthor() %></li>
        <% 
                }
            } 
        %>
    </ul>
</body>
</html>
