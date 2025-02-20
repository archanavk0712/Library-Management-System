<!DOCTYPE html>
<html>
<head>
    <title>Add Book</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <form action="AddBookServlet" method="post">
        <h2>Add Book</h2>
        <input type="number" name="id" placeholder="Book ID" required>
        <input type="text" name="title" placeholder="Book Title" required>
        <input type="text" name="author" placeholder="Author" required>
        <input type="number" name="quantity" placeholder="Quantity" required>
        <button type="submit">Add Book</button>
    </form>
</body>
</html>
