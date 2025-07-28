<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to BHU Mess Management</title>
    <style>
         body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-image: url("images/BHUI.jpg"); /* 🔁 Update path if needed */
            background-size: cover;
            background-repeat: no-repeat;
            background-position: centre;
            background-attachment: fixed;
            color: #008000;
            padding-top: 70px;
        }

        h1 {
            margin-bottom: 30px;
        }

        h2 {
            margin-top: 40px;
            margin-bottom: 10px;
            color: #333;
        }

        .btn1 {
            display: inline-block;
            margin: 8px;
            padding: 10px 25px;
            font-size: 16px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 6px;
            text-decoration: none;
            cursor: pointer;
            width: 200px;
        }

         .btn2 {
            display: inline-block;
            margin: 8px;
            padding: 10px 25px;
            font-size: 16px;
            background-color: #FF0000;
            color: white;
            border: none;
            border-radius: 6px;
            text-decoration: none;
            cursor: pointer;
            width: 200px;
        }
        .btn:hover {
            background-color: #0056b3;
        }

        .section {
            margin-bottom: 40px;
        }
    </style>
</head>
<body>
    <h1>Welcome to BHU Mess Management Portal</h1>

    <div class="section">
        <h2>Existing Users</h2>
        <a href="pages/login.jsp" class="btn1">Student Login</a>
        <a href="pages/messOwnerLogin.jsp" class="btn1">Mess Owner Login</a>
    </div>

    <div class="section">
        <h2>New User?</h2>
        <a href="student_register.jsp" class="btn1">Student Register</a> |
        <a href="mess_owner_register.jsp" class="btn1">Mess Owner Register</a>

    </div>
    
    <div class="section">
        <h2>Admin Panel</h2>
        <a href="pages/AdminLogin.jsp" class="btn2">Admin Login</a> |
        

    </div>
    
    <div class="section">
        <h2>ABOUT</h2>
        <p><a href="pages/aboutDeveloper.jsp" class="btn2">About the Developer</a></p>

        

    </div>
</body>
</html>
