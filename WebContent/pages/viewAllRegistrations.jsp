<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, com.bhu.mess.model.MessRegistration" %>
<%
    Object listObj = request.getAttribute("studentList");
    if (listObj == null) {
%>
    <p style="color: red;">No data found. Please access this page via the correct servlet.</p>
<%
    } else {
        @SuppressWarnings("unchecked")
        List<MessRegistration> list = (List<MessRegistration>) listObj;

        if (list.isEmpty()) {
%>
    <p>No registrations available.</p>
<%
        } else {
%>
    <h2>All Registered Students</h2>
    <table border="1" style="border-collapse: collapse;">
    <tr>
        <th style="padding: 10px;">Email</th>
        <th style="padding: 10px;">Mess Name</th>
        <th style="padding: 10px;">Joining Date</th>
        <th style="padding: 10px;">Meal Type</th>
    </tr>
        <%
            for (MessRegistration reg : list) {
        %>
        <tr>
            <td><%= reg.getEmail() %></td>
            <td><%= reg.getMessName() %></td>
            <td><%= reg.getJoiningDate() %></td>
            <td><%= reg.getMealType() %></td>
        </tr>
        <%
            }
        %>
    </table>
<%
        }
    }
%>
