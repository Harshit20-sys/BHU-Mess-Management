<%@ page import="java.util.List" %>
<%@ page import="com.bhu.mess.model.MessOwner" %>
<% @SuppressWarnings("unchecked")
    List<MessOwner> owners = (List<MessOwner>) request.getAttribute("messOwners");
%>
<!DOCTYPE html>
<html>
<head>
    <title>All Mess Owners</title>
</head>
<body>
    <h2>Registered Mess Owners</h2>
    <%
        if (owners == null || owners.isEmpty()) {
    %>
        <p>No mess owners registered yet.</p>
    <%
        } else {
    %>
        <table border="1" cellpadding="10">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Mess Name</th>
            </tr>
            <% for (MessOwner o : owners) { %>
            <tr>
                <td><%= o.getId() %></td>
                <td><%= o.getName() %></td>
                <td><%= o.getEmail() %></td>
                <td><%= o.getMessName() %></td>
            </tr>
            <% } %>
        </table>
    <%
        }
    %>
   
</body>
</html>
