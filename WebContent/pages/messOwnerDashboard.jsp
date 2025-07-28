<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%
    String email = (String) session.getAttribute("email");
    //if (email == null) {
      //  response.sendRedirect("pages/login.jsp");
        //return;
    
%>
<!DOCTYPE html>
<html>
<head>
    <title>Mess Owner Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            text-align: center;
        }
        h2 {
            color: #333;
        }
        .dashboard {
            margin-top: 50px;
        }
        .button {
            padding: 10px 20px;
            margin: 10px;
            font-size: 16px;
            border: none;
            background-color: #4285f4;
            color: white;
            border-radius: 5px;
            cursor: pointer;
        }
        .button:hover {
            background-color: #3367d6;
        }
    </style>
</head>
<body>
    <div class="dashboard">
        <h2>Welcome to Mess Owner Dashboard</h2>
        <p>Hello, <b><%= email %></b></p>
        

        <form action="pages/ViewMenuServlet" method="get"> <!-- ❌ WRONG -->
<li><a href="../ViewMenuServlet" style="display:inline-block; padding:10px 20px; background-color:#007BFF; color:white; text-decoration:none; border-radius:5px; margin-bottom: 10px;">View Weekly Menu</a></li>
<li><a href="../ViewRegisteredStudentsServlet" style="display:inline-block; padding:10px 20px; background-color:#007BFF; color:white; text-decoration:none; border-radius:5px; margin-bottom: 10px;">View All Registrations</a></li>
<li><a href="addMenu.jsp" style="display:inline-block; padding:10px 20px; background-color:#007BFF; color:white; text-decoration:none; border-radius:5px; margin-bottom: 10px;">Add New Day Menu</a></li>
<li><a href="viewFeedback.jsp" style="display:inline-block; padding:10px 20px; background-color:#007BFF; color:white; text-decoration:none; border-radius:5px; margin-bottom: 10px;">View Feedback</a></li>


        </form>

       
      
        
       

       <li><a href="logout.jsp?role=owner"style="display:inline-block; padding:10px 20px; background-color:#007BFF; color:white; text-decoration:none; border-radius:5px; margin-bottom: 10px;">Logout</a></li>
       
        
    </div>
</body>
</html>
