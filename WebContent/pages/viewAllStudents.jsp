<%@ page import="java.util.List" %>
<%@ page import="com.bhu.mess.model.User" %>
<%
    List<User> students = (List<User>) request.getAttribute("students");
    String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html>
<head>
    <title>All Registered Students</title>
</head>
<body>
    <h2>All Registered Students</h2>

    <% if (error != null) { %>
        <p style="color:red;"><%= error %></p>
    <% } else if (students != null && !students.isEmpty()) { %>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Age</th>
                <th>Role</th>
            </tr>
            <% for (User user : students) { %>
                <tr>
                    <td><%= user.getId() %></td>
                    <td><%= user.getName() %></td>
                    <td><%= user.getEmail() %></td>
                    <td><%= user.getPhone() %></td>
                    
                    <td><%= user.getRole() %></td>
                </tr>
            <% } %>
        </table>
    <% } else { %>
        <p>No data available.</p>
    <% } %>

    <br>
    <a href="pages/adminDashboard.jsp">Back to Dashboard</a>
</body>
</html>
