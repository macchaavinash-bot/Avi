# Royal Moments - Function Hall Booking

Beginner-friendly Java Web Application using:

- HTML
- CSS
- JavaScript
- Java Servlet
- JDBC
- MySQL
- Maven
- Apache Tomcat 10+

## Features

- Customer booking form
- Wedding, engagement, birthday, reception and other events
- Multiple function halls
- With decoration / without decoration
- With food / without food
- Multiple food item selection
- Guest count
- Event date validation
- Special requests
- JDBC database insertion
- PreparedStatement for safer SQL parameter handling

## Project structure

function-hall-booking/
├── pom.xml
├── README.md
├── database/
│   └── function_hall.sql
└── src/
    └── main/
        ├── java/
        │   └── com/functionhall/
        │       ├── dao/BookingDAO.java
        │       ├── model/Booking.java
        │       ├── servlet/BookingServlet.java
        │       └── util/DBConnection.java
        └── webapp/
            ├── index.html
            ├── success.html
            ├── css/style.css
            └── js/script.js

## Requirements

1. JDK 17+
2. MySQL 8+
3. Maven
4. Apache Tomcat 10+
5. IDE such as IntelliJ IDEA, Eclipse or VS Code

## Step 1 - Create the database

Open MySQL Workbench or MySQL command line.

Run:

SOURCE path/to/database/function_hall.sql;

Or copy/paste the SQL from the file.

## Step 2 - Configure MySQL password

Open:

src/main/java/com/functionhall/util/DBConnection.java

Change:

private static final String PASSWORD = "your_mysql_password";

to your actual MySQL password.

## Step 3 - Build

From the project root:

mvn clean package

The WAR file will be generated inside:

target/function-hall-booking.war

## Step 4 - Deploy

Copy the WAR to Tomcat's webapps folder.

Start Tomcat.

Open:

http://localhost:8080/function-hall-booking/

## How JDBC works in this project

Browser
   ↓
index.html
   ↓
POST /book
   ↓
BookingServlet
   ↓
BookingDAO
   ↓
PreparedStatement
   ↓
MySQL

## Interview explanation

If an interviewer asks "How did you use JDBC?", say:

"I created a Java Servlet-based function hall booking application. The HTML form collects customer and event information. The BookingServlet receives the form data and passes it to a DAO class. The DAO uses JDBC Connection and PreparedStatement to insert the booking into MySQL. I used PreparedStatement instead of string-concatenated SQL to safely handle user input."

## Important JDBC classes used

Connection:
Creates the connection to MySQL.

DriverManager:
Creates the JDBC connection.

PreparedStatement:
Executes parameterized SQL.

SQLException:
Handles database errors.

## Future improvements

- Login and registration
- Admin dashboard
- Check hall availability before booking
- Booking cancellation
- Payment integration
- Email/SMS confirmation
- Image gallery
- Price calculation
- Admin CRUD for halls and food
- Connection pooling
- Spring Boot REST API
