<%@ page import="java.sql.*, javax.servlet.http.*, javax.servlet.*" %>
<%
   
    String email = (String) session.getAttribute("email");

    boolean isRegistered = false;

    if (email != null) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhu_mess_management", "root", "89321");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM mess_registration WHERE email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                isRegistered = true;
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<html>
<head><title>Register in Mess</title></head>
<body>
    <h2>Mess Registration</h2>

<% if (isRegistered) { %>
    <p style="color: green;">You are already registered in mess.</p>
    <p><a href="editMessRegistration.jsp">Edit My Mess Registration</a></p>
<% } else { %>
    <form action="<%= request.getContextPath() %>/RegisterInMessServlet" method="post">
        <label>Email:</label>
        <input type="text" name="email" value="<%= email %>" readonly /><br><br>

        <label>Mess Name:</label>
        <select name="messName" required>
            <option value="">-- Select Mess --</option>
            <option value="North Mess">North Mess</option>
            <option value="South Mess">South Mess</option>
            <option value="PG Mess">PG Mess</option>
        </select><br><br>

        <label>Meal Type:</label>
        <select name="mealType" required>
            <option value="">-- Select Meal Type --</option>
            <option value="Veg">Veg</option>
            <option value="Non-Veg">Non-Veg</option>
        </select><br><br>

        <label>Joining Date:</label>
        <input type="date" name="joiningDate" required /><br><br>

        <input type="submit" value="Register" />
    </form>
<% } %>
</body>
</html>
