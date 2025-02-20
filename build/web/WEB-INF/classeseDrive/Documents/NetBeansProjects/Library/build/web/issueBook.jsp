<!DOCTYPE html>
<html>
<head>
    <title>Issue Book</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Issue a Book</h2>
    <form action="IssueBookServlet" method="post">
        <label>Book ID:</label>
        <input type="number" name="bookId" required>
        <button type="submit">Issue</button>
    </form>
</body>
</html>
