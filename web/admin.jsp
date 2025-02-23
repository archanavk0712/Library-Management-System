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
    <style>
        body {
            background-image: url("images/admin.jpg");
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            text-align: center;
        }

        h2 {
            color: white;
            background-color: #3498db;
            padding: 15px 30px;
            border-radius: 10px;
            font-size: 28px;
            font-weight: bold;
            position: absolute;
            top: 20px;
            text-align: center;
        }
        
        .dashboard-container {
            background: rgba(255, 255, 255, 0.2);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
            backdrop-filter: blur(10px);
            text-align: center;
            width: 350px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        a {
            display: block;
            width: 100%;
            text-align: center;
            padding: 12px;
            font-size: 18px;
            font-weight: bold;
            color: white;
            background: #2c3e50;
            text-decoration: none;
            border-radius: 5px;
            margin: 10px 0;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            transition: 0.3s;
        }

        a:hover {
            background: #1a252f;
            transform: scale(1.05);
        }
    </style>    
</head>
<body>
    <h2>Admin Dashboard</h2>
    <div class="dashboard-container">
        <a href="addBook.jsp">Add Book</a>   <!-- Added Add Book Option -->
        <a href="addStudent.jsp">Add Student</a>
        <a href="viewBooks.jsp">View Books</a>
        <a href="viewStudents.jsp">View Students</a>
        <a href="LogoutServlet">Logout</a>
    </div>
</body>
</html>
