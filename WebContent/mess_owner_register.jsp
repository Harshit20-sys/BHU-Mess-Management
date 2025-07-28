<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Mess Owner Registration</title>
</head>
<body>
    <h2>Mess Owner Registration</h2>

    <% String error = request.getParameter("error");
       if ("failed".equals(error)) { %>
        <p style="color:red;">Registration failed. Try again.</p>
    <% } %>

    <form action="MessOwnerRegisterServlet" method="post">
        <input type="text" name="name" placeholder="Your Name" required><br><br>
        <input type="email" name="email" placeholder="Your Email" required><br><br>
        <input type="password" name="password" placeholder="Password" required><br><br>
        <input type="text" name="messName" placeholder="Mess Name" required><br><br>
        <input type="text" name="messAddress" placeholder="Mess Address" required><br><br>
        <button type="submit">Register</button>
    </form>

    <a href="pages/messOwnerLogin.jsp">Already have an account? Login</a>

</body>
</html>
