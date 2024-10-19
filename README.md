
# Restaurant Reservation System

This is a web-based restaurant reservation system built using **Java EE**, **JSP**, **Servlets**, and **JDBC**. The project connects to a MySQL database using MySQL Connector/J and runs on an **Apache Tomcat** server.

## Features
- View restaurant table bookings.
- User roles (admin and customer).
- Integration with MySQL database.
- Dynamic web interface using JSP, Servlets, and Fetch API.

## Prerequisites

### 1. MySQL Installation
**Download MySQL:**
- Go to the official [MySQL Community Downloads](https://dev.mysql.com/downloads/mysql/) page and select your operating system.

**Install MySQL:**
- Follow the instructions provided by MySQL to install the database server. Make sure to remember the root user credentials as they will be used in the project.

**Start MySQL Server:**
- Ensure your MySQL server is running. You can manage the server using the MySQL Workbench or through the command line.

**Database Setup:**
- In the root directory of this project, you'll find a file named `SQLSchema.sql`. This file contains the SQL code to set up the necessary database and tables.

To set up the database:
1. Open MySQL Workbench or the command line.
2. Run the SQL script located in `SQLSchema.sql` to create the necessary tables.

### 2. Apache Tomcat Installation and Setup
**Download Tomcat:**
- Download the Apache Tomcat version 9.x or later, depending on your needs.

**Install Tomcat:**
- Extract the downloaded file and place it in a location of your choice. No installation is needed as Tomcat runs directly from the folder.

**Configure Tomcat in Eclipse:**
1. Open Eclipse and navigate to **Window > Preferences > Server > Runtime Environments**.
2. Click **Add** and select the appropriate Tomcat version.
3. Browse to the Tomcat installation folder you extracted earlier.
4. Set up the server and make sure it's running without issues by starting it from **Servers** in Eclipse.

### 3. Database Setup
To set up the MySQL database schema:
1. Navigate to the root of this project in the GitHub repository.
2. Locate the file named `SQLSchema.sql`.
3. Execute the contents of the SQL file to create the necessary database schema.

### 4. Adding MySQL Connector/J to Your Project
**Download MySQL Connector/J:**
- Go to the [MySQL Connector/J download page](https://dev.mysql.com/downloads/connector/j/).
- Choose **Platform Independent** and download the ZIP archive.

**Add to the Project:**
1. Place the `mysql-connector-java-x.x.xx.jar` file into your project’s `WEB-INF/lib` directory.
2. Right-click the project in Eclipse and choose **Build Path > Configure Build Path**. Then, add the JAR to the Classpath.

### 5. Run the Project
**Start Tomcat:**
- Ensure that your Apache Tomcat server is running from Eclipse.

**Deploy the Project:**
- Right-click the project and select **Run As > Run on Server**.

**Access the Dashboard:**
- Open your browser and go to: 
  ```
  http://localhost:8080/RestaurantReservation/Dashboard.jsp
  ```
  This will display the restaurant reservation dashboard.

## File Structure
```
RestaurantReservation/
│
├── src/                      # Source code folder
│   ├── main/
│   │   ├── java/              # Java packages
│   │   │   └── dashboard/
│   │   │       ├── Dashboard.java
│   │   │       ├── DatabaseConnection.java
│   │   │       └── FetchBookingsServlet.java
│   └── webapp/
│       ├── WEB-INF/
│       │   ├── lib/           # Contains MySQL Connector/J and other JARs
│       └── Dashboard.jsp      # The JSP file for the dashboard
│
├── SQLSchema.sql              # SQL script to set up the database schema
├── pom.xml                    # (Optional) If using Maven
└── README.md                  # Project readme file
```

## Technologies Used
- Java SE 21
- JSP and Servlets
- MySQL 8.x
- MySQL Connector/J
- Apache Tomcat 9.x
- HTML/CSS/Bootstrap
- JavaScript (Fetch API)

## Troubleshooting
### 1. Common Errors
- **MySQL connection issues:** Double-check the connection string in `DatabaseConnection.java`. Ensure the correct username, password, and database URL are provided.
- **Tomcat server errors:** Make sure Tomcat is correctly installed and configured in Eclipse. You can test Tomcat by starting it without deploying your project to ensure it runs properly.
- **Database tables missing:** Ensure the SQL script (`SQLSchema.sql`) is executed correctly in MySQL Workbench.

## License
This project is open-source and available under the **MIT License**.

## Contribution Guidelines
Feel free to contribute to the project by forking the repository and submitting a pull request.

## Additional Notes
- Always ensure you have MySQL and Tomcat running before deploying and testing the application.
- If you're not using Maven, ensure that any external libraries, such as `mysql-connector-java.jar`, are manually placed in the `WEB-INF/lib` folder.
