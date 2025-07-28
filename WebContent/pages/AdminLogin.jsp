<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            padding: 40px;
        }
        input, button {
            padding: 10px;
            margin: 10px;
        }
        .error {
            color: red;
        }
        .link {
            margin-top: 20px;
            display: block;
        }
    </style>
</head>
<body>

<%
    String success = request.getParameter("success");
    if ("registered".equals(success)) {
%>
    <p style="color: green;">Registration successful! Please login.</p>
<%
    }
%>

    <h2>Admin Login</h2>
    <form action="../AdminLoginServlet" method="post">
        <input type="email" name="email" placeholder="Admin Email" required /><br>
        <input type="password" name="password" placeholder="Password" required /><br>
        <button type="submit">Login</button>
    </form>

    <% if (request.getParameter("error") != null) { %>
        <p class="error">Invalid Email or Password</p>
    <% } %>

    <!-- ✅ Only back to home link for Admin -->
    <a href="../index.jsp" class="link">Back to Home</a>
</body>
</html>
