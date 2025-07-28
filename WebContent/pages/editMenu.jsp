<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.bhu.mess.model.Menu" %>
<%
    Menu menu = (Menu) request.getAttribute("menu");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Menu</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        .message { padding: 10px; margin-bottom: 20px; border-radius: 4px; }
        .success { background-color: #e0ffe0; color: #006600; }
        .error { background-color: #ffe0e0; color: #990000; }
    </style>
</head>
<body>

    <h2>Edit Menu for <%= (menu != null) ? menu.getDay() : "N/A" %></h2>

    <% 
        String error = request.getParameter("error");
        String success = request.getParameter("success");

        if ("update_failed".equals(error)) {
    %>
        <div class="message error">❌ Failed to update menu. Please try again.</div>
    <% 
        } else if ("updated".equals(success)) {
    %>
        <div class="message success">✅ Menu updated successfully!</div>
    <%
        }
    %>

    <%
        if (menu == null) {
    %>
        <p style="color: red;">⚠️ Error: No menu data found to edit. Please go back and try again.</p>
        <p><a href="viewMenu.jsp">Back to Menu</a></p>
    <%
        } else {
    %>

    <form action="EditMenuServlet" method="post">
        <input type="hidden" name="id" value="<%= menu.getId() %>">
        <input type="hidden" name="day" value="<%= menu.getDay() %>">

        <label>Breakfast:</label><br>
        <textarea name="breakfast" required><%= menu.getBreakfast() %></textarea><br><br>

        <label>Lunch:</label><br>
        <textarea name="lunch" required><%= menu.getLunch() %></textarea><br><br>

        <label>Dinner:</label><br>
        <textarea name="dinner" required><%= menu.getDinner() %></textarea><br><br>

        <input type="submit" value="Update">
    </form>

          <p><a href="pages/viewMenu.jsp">Back to Menu</a></p>
    <%
        }
    %>

</body>
</html>
