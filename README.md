# Library-Management-System

## Overview
The **Library Management System** is a web-based application designed to manage books, students, and the issuing/returning of books efficiently. It supports user authentication and provides functionalities for both **admin** and **student** roles.

## Features
- **User Registration & Login** (Admin & Student)
- **Admin Panel**
  - Add new books
  - Issue books to students
  - View and manage registered students
  - View all issued books
  - Manage book returns
- **Student Panel**
  - View available books
  - Request book issue
  - View issued books and return books
- **Secure Authentication** using Jakarta EE Servlets
- **Oracle Database Integration**
- **Styled UI** using HTML, CSS

## Technologies Used
- **Frontend:** HTML, CSS, JSP
- **Backend:** Jakarta EE (Servlets, JSP)
- **Database:** Oracle Database
- **Server:** Apache Tomcat

## Project Structure
```
LibraryManagementSystem/
│── src/
│   ├── dao/
│   │   ├── BookDAO.java
│   │   ├── UserDAO.java
│   ├── model/
│   │   ├── User.java
│   ├── servlets/
│   │   ├── LoginServlet.java
│   │   ├── LogoutServlet.java
│   │   ├── RegisterServlet.java
│   │   ├── ViewBooksServlet.java
│   │   ├── ViewStudentsServlet.java
│── WebContent/
│   ├── css/
│   │   ├── style.css
│   ├── jsp/
│   │   ├── addStudent.jsp
│   │   ├── admin.jsp
│   │   ├── issueBook.jsp
│   │   ├── returnBook.jsp
│   │   ├── student.jsp
│   │   ├── viewBooks.jsp
│   │   ├── viewStudents.jsp
│   │   ├── register.jsp
│   ├── index.html
│   ├── login.html
│── README.md
│── pom.xml (if using Maven)
```

## Installation & Setup
### Prerequisites:
- Install **Oracle Database**
- Install **Apache Tomcat Server**
- Install **NetBeans IDE** (or any preferred Java IDE)

### Steps to Run the Project:
1. Clone the repository:
   ```sh
   git clone https://github.com/archanavk0712/library-management-system.git
   ```
2. Open the project in **NetBeans**.
3. Configure **Oracle Database** connection in `UserDAO.java` and `BookDAO.java`.
4. Deploy the project on **Tomcat Server**.
5. Open `http://localhost:8080/LibraryManagementSystem/` in a browser.
