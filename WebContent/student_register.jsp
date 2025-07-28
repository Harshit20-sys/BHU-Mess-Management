<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Registration</title>
</head>
<body>
    <h2>Student Registration</h2>

    <% String error = request.getParameter("error");
       if ("failed".equals(error)) { %>
        <p style="color:red;">Registration failed. Try again.</p>
    <% } %>

    <form action="RegisterServlet" method="post">
        <input type="text" name="name" placeholder="Your Name" required><br><br>
        <input type="email" name="email" placeholder="Your Email" required><br><br>
        <input type="password" name="password" placeholder="Password" required><br><br>
        <input type="number" name="age" placeholder="Your Age" required><br><br>
        <button type="submit">Register</button>
    </form>

    <p><a href="pages/login.jsp">Already have an account? Login</a></p>
</body>
</html>
