<%@ page session="true" %>
<%
    if (session.getAttribute("userRole") == null || !session.getAttribute("userRole").equals("student")) {
        response.sendRedirect("login.html");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Dashboard</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Student Dashboard</h2>
    <a href="viewBooks.jsp">View Books</a>
    <a href="issueBook.jsp">Issue Book</a>
    <a href="returnBook.jsp">Return Book</a>
    <a href="LogoutServlet">Logout</a>
</body>
</html>
