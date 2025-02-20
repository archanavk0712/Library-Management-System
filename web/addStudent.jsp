<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Add Student</h2>
    <form action="AddStudentServlet" method="post">
        <label>Student ID:</label>
        <input type="text" name="studentId" required><br>

        <label>Name:</label>
        <input type="text" name="name" required><br>

        <label>Email:</label>
        <input type="email" name="email" required><br>

        <!-- New Fields -->
        <label>Book Name:</label>
        <input type="text" name="bookName" required><br>

        <label>Author:</label>
        <input type="text" name="author" required><br>

        <button type="submit">Add Student</button>
    </form>
</body>
</html>
