<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, com.library.models.Student, com.library.dao.StudentDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Students</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Student List</h2>
    <table border="1">
        <tr>
            <th>Student ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Book</th>   <!-- Added Book column -->
            <th>Author</th> <!-- Added Author column -->
        </tr>

        <%
            StudentDAO studentDAO = new StudentDAO();
            List<Student> students = studentDAO.getAllStudents();

            for (Student student : students) {
        %>
        <tr>
            <td><%= student.getStudentId() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getEmail() %></td>
            <td><%= student.getBook() %></td>    <!-- Display book -->
            <td><%= student.getAuthor() %></td>  <!-- Display author -->
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
