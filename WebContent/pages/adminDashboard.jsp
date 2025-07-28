<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String adminEmail = (String) session.getAttribute("adminEmail");
    if (adminEmail == null) {
        response.sendRedirect("adminLogin.jsp?error=unauthorized");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            padding-top: 60px;
            background-color: #f0f8ff;
        }

        h1 {
            color: #333;
        }

        .btn {
            display: inline-block;
            margin: 10px;
            padding: 10px 25px;
            font-size: 16px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 6px;
            text-decoration: none;
            cursor: pointer;
        }

        .btn:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <h1>Welcome to Admin Dashboard</h1>
     <h2>Welcome, <%= adminEmail %></h2>
    
    <a href="${pageContext.request.contextPath}/ViewRegisteredStudentsServlet"class="btn">View All Students</a>
    <a href="${pageContext.request.contextPath}/AdminViewMessOwnersServlet"class="btn">View All Mess Owners</a>
    <a href="logout.jsp" class="btn">Logout</a>
    
    
</body>
</html>
