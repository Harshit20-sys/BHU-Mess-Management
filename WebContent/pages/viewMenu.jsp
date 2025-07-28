<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.bhu.mess.model.Menu" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Weekly Menu</title>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin: auto;
        }
        th, td {
            border: 1px solid #555;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f0f0f0;
        }
        .center {
            text-align: center;
            margin-top: 20px;
        }
        .btn {
            margin: 10px;
            padding: 8px 16px;
            background-color: #008CBA;
            color: white;
            border: none;
            border-radius: 4px;
            text-decoration: none;
        }
        .btn:hover {
            background-color: #005f75;
        }
    </style>
</head>
<body>

    <h2 class="center">Mess Weekly Menu</h2>

    <%
    @SuppressWarnings("unchecked")
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
                <td>
                        <a href="EditMenuFormServlet?day=<%= menu.getDay() %>">Edit</a>
                    </td>
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
        
        <a href="${pageContext.request.contextPath}/pages/messOwnerDashboard.jsp" class="btn">Back to Dashboard</a>

    </div>
</body>
</html>
