<%@ page import="com.library.models.User" %>
<%@ page session="true" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null || !"admin".equals(user.getRole())) {
        response.sendRedirect("login.html");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Admin Dashboard</h2>
    <a href="addStudent.jsp">Add Student</a>
    <a href="viewBooks.jsp">View Books</a>
    <a href="viewStudents.jsp">View Students</a>
    <a href="LogoutServlet">Logout</a>
</body>
</html>
