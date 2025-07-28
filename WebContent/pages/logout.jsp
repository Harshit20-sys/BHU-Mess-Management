<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    session.invalidate();  // Destroy session

    // Optional: check role to redirect accordingly
    String role = request.getParameter("role");

    if ("student".equals(role)) {
        response.sendRedirect("login.jsp");  // Student login page
    } else if ("owner".equals(role)) {
        response.sendRedirect("messOwnerLogin.jsp");  // Mess owner login
    } else {
    	response.sendRedirect(request.getContextPath() + "/index.jsp");

    }
%>
