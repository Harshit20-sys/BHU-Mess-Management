<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String email = (String) session.getAttribute("email");
    //if (email == null) {
      //  response.sendRedirect("pages/login.jsp");
        //return;
    
%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            padding: 40px;
            text-align: center;
        }

        h1 {
            color: #000000.;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            margin: 15px 0;
        }

        a {
            text-decoration: none;
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border-radius: 6px;
            display: inline-block;
        }

        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <h1>Welcome to Student Dashboard</h1>
    <p>Hello, <b><%= email %></b></p>

    <ul>
           
        
        <li><a href="${pageContext.request.contextPath}/AdminViewMessOwnersServlet"class="btn">View All Mess Owners</a></li>
        <li><a href="${pageContext.request.contextPath}/pages/viewMessRegistration.jsp">View My Mess Registration</a></li>
        <li><a href="${pageContext.request.contextPath}/MenuServlet" class="tab-button">View My Mess Menu</a></li>
        <li><a href="${pageContext.request.contextPath}/pages/logout.jsp?role=student">Logout</a></li>
    </ul>

</body>
</html>
