# 🏫 BHU Mess Management Portal

A complete web-based solution built for Banaras Hindu University (BHU) to streamline mess registration and management for students. The portal allows students to register for a mess, view mess options, access menus, and manage their registrations digitally.

---

## 📌 Table of Contents

- [About the Project](#about-the-project)
- [Project Objectives](#project-objectives)
- [Key Features](#key-features)
- [System Architecture](#system-architecture)
- [Database Design](#database-design)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [How to Run the Project](#how-to-run-the-project)
- [Screenshots](#screenshots)
- [Future Enhancements](#future-enhancements)
- [Author](#author)
- [License](#license)

---

## 📖 About the Project

The **BHU Mess Management Portal** is a Servlet-based web application created to automate and digitize the traditional mess registration system. Students at BHU often face confusion regarding mess options, registration deadlines, and menu details. This portal addresses all of those issues by bringing everything online with a student-centric design.

---

## 🎯 Project Objectives

- ✅ Provide a centralized platform for BHU students to register for messes
- ✅ Display available messes and their food menus
- ✅ Allow students to view their current and past registrations
- ✅ Simplify the mess selection process
- ✅ Eliminate manual errors and paperwork

---

## 🔑 Key Features

### 👨‍🎓 Student Module
- **Registration/Login:** Students can create accounts and securely log in.
- **Register in Mess:** Select and register for a mess from a list.
- **View My Registrations:** Review your mess registration history.
- **View Registered Messes:** Explore all messes available in the system.
- **View Menu:** See the common mess menu (same for all messes).
- **My Mess Menu:** Check the current week's menu of the mess you've registered in.
- **Logout:** Securely log out of the portal.

---

## 🏗️ System Architecture

User (Browser)
↓
HTTP Request
↓
Apache Tomcat Server (Servlet Controller)
↓
JSP Pages (Frontend Views)
↓
DAO Layer (Database Interaction)
↓
MySQL Database


- **MVC Structure:** The application uses a Model-View-Controller (MVC) design pattern.
- **JSPs** serve the UI, **Servlets** act as controllers, and **DAOs** manage database logic.

---

## 🗃️ Database Design

### Database: `bhu_mess`

#### Tables:

1. **`students`**
   - `id` (INT, PK, AUTO_INCREMENT)
   - `name` (VARCHAR)
   - `email` (VARCHAR, unique)
   - `password` (VARCHAR)

2. **`messes`**
   - `id` (INT, PK)
   - `mess_name` (VARCHAR)
   - `location` (VARCHAR)

3. **`registrations`**
   - `id` (INT, PK)
   - `student_id` (FK → students.id)
   - `mess_id` (FK → messes.id)
   - `registration_date` (DATE)

4. **`menu`**
   - `id` (INT, PK)
   - `day` (VARCHAR) — e.g., Monday
   - `breakfast` (VARCHAR)
   - `lunch` (VARCHAR)
   - `dinner` (VARCHAR)



---

## 🧰 Tech Stack

| Layer        | Technology        |
|--------------|-------------------|
| Frontend     | HTML, CSS         |
| Backend      | Java (Servlets, JSP) |
| Database     | MySQL             |
| Server       | Apache Tomcat 9.0 |
| IDE          | Eclipse IDE       |

---

## 📁 Project Structure

BHU_MESS_MANAGEMENT/
├── src/
│ ├── controller/ # Servlets (business logic)
│ ├── dao/ # Database access (JDBC)
│ └── model/ # POJOs / Beans
├── WebContent/
│ ├── css/ # Stylesheets
│ ├── pages/ # JSP pages (views)
│ ├── screenshots/ # Images for README
│ └── WEB-INF/
│ └── web.xml # Deployment descriptor
└── SQL/
└── bhu_mess.sql # Database schema


## 🖼️ Screenshots

### 🏠 Dashboard
![Dashboard](https://github.com/Harshit20-sys/BHU-Mess-Management/blob/7dfca2a66e6d5e05cb6f303161e03f64c2f2d147/WebContent/images/Screenshot%202025-07-31%20071731.png)


### 🏠 Student Dashboard
![Student Dashboard](https://github.com/Harshit20-sys/BHU-Mess-Management/blob/28ffdd7c7f8a89567473a8a1182fe77180312bd5/WebContent/images/Screenshot%202025-07-31%20071756.png)



### 📋 Mess Owner Dashboard
![Mess Owner Dashboard]()


### 📋 Admin Dashboard
![Admin Dashboard]()


### 🍛 View Menu
![Mess Menu](screenshots/view_menu.png)



## ⚙️ How to Run the Project

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/your-username/BHU-Mess-Management.git


🔮 Future Enhancements
🔐 Admin login to manage messes

📊 Analytics dashboard for mess usage

📅 Meal booking for specific days

📩 Email/SMS notifications on registration

📱 Mobile app version

👨‍💻 Author
Harshit Singh

🎓 Backend & Database Developer

🌐 Harshit20-sys

📧 harshitgaharwar20@gmail.com

📄 License
This project is licensed under the MIT License. See the LICENSE file for details.
