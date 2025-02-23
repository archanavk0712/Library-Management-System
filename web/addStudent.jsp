<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url("images/addStudent.jpg");
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
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

        .form-container {
            background: rgba(255, 255, 255, 0.2);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
            backdrop-filter: blur(10px);
            text-align: center;
            width: 350px;
            margin-top: 80px;
        }

        label {
            font-weight: bold;
            display: block;
            margin-top: 10px;
            text-align: left;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        button {
            width: 100%;
            padding: 12px;
            font-size: 18px;
            font-weight: bold;
            color: white;
            background: #2c3e50;
            text-decoration: none;
            border: none;
            border-radius: 5px;
            margin-top: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            cursor: pointer;
            transition: 0.3s;
        }

        button:hover {
            background: #1a252f;
            transform: scale(1.05);
        }

        /* ✅ Styling for the "Back to Admin Dashboard" button */
        .back-btn {
            width: 100%;
            padding: 12px;
            font-size: 18px;
            font-weight: bold;
            color: white;
            background: #e74c3c;
            border: none;
            border-radius: 5px;
            margin-top: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            cursor: pointer;
            transition: 0.3s;
        }

        .back-btn:hover {
            background: #c0392b;
            transform: scale(1.05);
        }
    </style>

    <script>
        // ✅ Function to display popup if error is present in URL
        window.onload = function() {
            const urlParams = new URLSearchParams(window.location.search);
            const errorMessage = urlParams.get('error');
            if (errorMessage) {
                alert(errorMessage);  // Show error message as a popup
            }
        };
    </script>
</head>
<body>
    <h2>Add Student</h2>
    <div class="form-container">
        <form action="AddStudentServlet" method="post">
            <label>Student ID:</label>
            <input type="text" name="studentId" required>

            <label>Name:</label>
            <input type="text" name="name" required>

            <label>Email:</label>
            <input type="email" name="email" required>

            <!-- New Fields -->
            <label>Book Name:</label>
            <input type="text" name="bookName" required>

            <label>Author:</label>
            <input type="text" name="author" required>

            <button type="submit">Add Student</button>
        </form>

        <!-- ✅ Back to Admin Dashboard Button -->
        <button class="back-btn" onclick="window.location.href='admin.jsp'">Back to Admin Dashboard</button>
    </div>
</body>
</html>
