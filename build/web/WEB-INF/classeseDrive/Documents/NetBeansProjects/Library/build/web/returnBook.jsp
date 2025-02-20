<!DOCTYPE html>
<html>
<head>
    <title>Return Book</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Return a Book</h2>
    <form action="ReturnBookServlet" method="post">
        <label>Book ID:</label>
        <input type="number" name="bookId" required>
        <button type="submit">Return</button>
    </form>
</body>
</html>
