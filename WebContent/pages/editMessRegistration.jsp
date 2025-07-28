<%@ page import="java.sql.*, javax.servlet.*, javax.servlet.http.*" %>



<%
   
    String email = (String) session.getAttribute("email");
    String messName = "", mealType = "", joiningDate = "";

    if (email != null) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhu_mess_management", "root", "89321");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM mess_registration WHERE email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                messName = rs.getString("mess_name");
                mealType = rs.getString("meal_type");
                joiningDate = rs.getString("joining_date");
           }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
%>

<html>
<head><title>Edit Mess Registration</title></head>
<body>
    <h2>Edit Your Mess Registration</h2>
    <form action="<%= request.getContextPath() %>/UpdateMessServlet" method="post">

        <label>Mess Name:</label>
        <input type="text" name="messName" value="<%= messName %>" required /><br><br>

        <label>Mess ID:</label>
        <input type="text" name="messId" value=" ID " required /><br><br>
        
        <label>Joining Date:</label>
        <input type="date" name="joiningDate" value="<%= joiningDate %>" required /><br><br>

        <label>Meal Type:</label>
        <select name="mealType">
            <option value="Veg" <%= "Veg".equals(mealType) ? "selected" : "" %>>Veg</option>
            <option value="Non-Veg" <%= "Non-Veg".equals(mealType) ? "selected" : "" %>>Non-Veg</option>
        </select><br><br>

        <input type="submit" value="Update">
    </form>
</body>
</html>
