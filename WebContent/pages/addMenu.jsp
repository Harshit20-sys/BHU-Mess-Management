<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.bhu.mess.model.Menu" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Day Menu</title>
    <style>
        body { font-family: Arial; margin: 20px; }
        h2 { color: #333; }
        textarea { width: 300px; height: 60px; }
        input[type="submit"] { margin-top: 10px; }
    </style>
</head>
<body>
    <h2>Add New Day Menu</h2>
    <form action="../AddMenuServlet" method="post">
        <label>Day:</label><br>
        <input type="text" name="day" required/><br><br>

        <label>Breakfast:</label><br>
        <textarea name="breakfast" required></textarea><br><br>

        <label>Lunch:</label><br>
        <textarea name="lunch" required></textarea><br><br>

        <label>Dinner:</label><br>
        <textarea name="dinner" required></textarea><br><br>

        <input type="submit" value="Add Menu"/>
    </form>
</body>
</html>
