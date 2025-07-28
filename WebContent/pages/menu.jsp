<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.bhu.mess.model.Menu" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mess Weekly Menu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            padding: 20px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 12px;
            border: 1px solid #aaa;
            text-align: center;
        }
        th {
            background-color: #f0f0f0;
            font-weight: bold;
        }
        .center {
            text-align: center;
            margin-top: 20px;
        }
        .btn {
            background-color: #1976d2;
            color: white;
            padding: 10px 20px;
            border: none;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
        }
        .btn:hover {
            background-color: #0d47a1;
        }
    </style>
</head>
<body>

    <h2>Mess Weekly Menu</h2>

<%
    List<Menu> menuList = (List<Menu>) request.getAttribute("menuList");

    if (menuList != null && !menuList.isEmpty()) {
%>
    <table>
        <tr>
            <th>Day</th>
            <th>Breakfast</th>
            <th>Lunch</th>
            <th>Dinner</th>
        </tr>
        <%
            for (Menu menu : menuList) {
        %>
        <tr>
            <td><%= menu.getDay() %></td>
            <td><%= menu.getBreakfast() %></td>
            <td><%= menu.getLunch() %></td>
            <td><%= menu.getDinner() %></td>
        </tr>
        <%
            }
        %>
    </table>
<%
    } else {
%>
    <div class="center">
        <p style="color:red;">No menu available. Please add data first.</p>
    </div>
<%
    }
%>

    <div class="center">
        <a href="${pageContext.request.contextPath}/pages/studentDashboard.jsp" class="btn">Back to Dashboard</a>
    </div>

</body>
</html>
