<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register - Mess Portal</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <h2>Register Here</h2>
    <form action="../RegisterServlet" method="post">
        <label>Name:</label><br>
        <input type="text" name="name" required><br><br>

        <label>Email:</label><br>
        <input type="email" name="email" required><br><br>

        <label>Password:</label><br>
        <input type="password" name="password" required><br><br>

        <label>Role:</label><br>
        <select name="role">
            <option value="student">Student</option>
            <option value="owner">Mess Owner</option>
        </select><br><br>

        <label>Age:</label><br>
        <input type="number" name="age" required><br><br>

        <input type="submit" value="Register">
    </form>
</body>
</html>
