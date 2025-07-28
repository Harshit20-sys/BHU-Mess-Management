<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Mess Owner Login</title>
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
        .extra-links {
            margin-top: 40px;
        }
        .extra-links a {
            display: block;
            margin: 8px;
            color: #007bff;
            text-decoration: none;
        }
        .extra-links a:hover {
            text-decoration: underline;
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

    <h2>Mess Owner Login</h2>
    <form action="../MessOwnerLoginServlet" method="post">
        <input type="email" name="email" placeholder="Email" required /><br>
        <input type="password" name="password" placeholder="Password" required /><br>
        <button type="submit">Login</button>
    </form>

    <% if (request.getParameter("error") != null) { %>
        <p class="error">Invalid Email or Password</p>
    <% } %>

    <!-- ✅ Additional Navigation Links -->
    <div class="extra-links">
        <a href="../mess_owner_register.jsp" class="link">New user? Register here</a>
        
        <a href="../index.jsp">Back to Home</a>
    </div>

</body>
</html>
