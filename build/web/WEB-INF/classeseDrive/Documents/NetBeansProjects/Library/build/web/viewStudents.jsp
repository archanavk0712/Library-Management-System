<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, com.library.models.Student, com.library.dao.StudentDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Students</title>
    <style>
        body {
            background-image: url("images/view.jpg");
            font-family: Arial, sans-serif;
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

        td {
            background-color: #ffffff;
        }

        tr:nth-child(even) td {
            background-color: #f9f9f9;
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

        .no-students {
            color: red;
            font-size: 18px;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h2>Student List</h2>

    <%
        StudentDAO studentDAO = new StudentDAO();
        List<Student> students = studentDAO.getAllStudents();
    %>

    <% if (students.isEmpty()) { %>
        <p class="no-students">No students found.</p>
    <% } else { %>
        <table>
            <tr>
                <th>Student ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Book</th>
                <th>Author</th>
                <th>Action</th> <!-- New Column for Remove Button -->
            </tr>
            <% for (Student student : students) { %>
            <tr>
                <td><%= student.getStudentId() %></td>
                <td><%= student.getName() %></td>
                <td><%= student.getEmail() %></td>
                <td><%= student.getBook() %></td>
                <td><%= student.getAuthor() %></td>
                <td>
                    <form action="RemoveStudentServlet" method="post" style="display:inline;">
                        <input type="hidden" name="studentId" value="<%= student.getStudentId() %>">
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
