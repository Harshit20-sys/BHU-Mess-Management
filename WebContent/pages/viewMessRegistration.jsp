<%@ page import="java.sql.*, javax.servlet.*, javax.servlet.http.*" %>



<%
  
    String email = (String) session.getAttribute("email");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Your Mess Registration</title>
</head>
<body>
    <h2>Your Mess Registration Details</h2>

<%
    if (email != null) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhu_mess_management", "root", "89321");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM mess_registration WHERE email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
%>
                <p><strong>Mess Name:</strong> <%= rs.getString("mess_name") %></p>
                <p><strong>Joining Date:</strong> <%= rs.getDate("joining_date") %></p>
                <p><strong>Meal Type:</strong> <%= rs.getString("meal_type") %></p>
                <p><a href="editMessRegistration.jsp">Edit My Mess Registration</a></p>
                
<%
            } else {
%>
                <p>You have not registered in any mess yet.</p>
<%
            }

            con.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    } else {
%>
        <p>You are not logged in.</p>
<%
    }
%>
</body>
</html>
