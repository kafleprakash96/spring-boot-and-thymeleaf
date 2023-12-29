# Spring Boot Application with Thymeleaf and Spring Data JPA

This is a CRUD (Create, Read, Update, Delete) web application built with Spring Boot, Thymeleaf, and Spring Data JPA. It uses a MySQL database for data storage.

## Prerequisites

Before running the application, ensure you have the following installed:

- Java 17
- Maven
- MySQL Database

## Configuration

### 1. Clone the repository:

### 2. Navigate to the project directory:

    cd spring-boot-and-thymeleaf


### 3. Open the src/main/resources/application.properties file and update the following properties:

- spring.datasource.url=jdbc:mysql://localhost:3306/your-schema?useSSL=false
- spring.datasource.username=your-username
- spring.datasource.password=your-password 

### 4. Run the Application
To run the application, use the following Maven command:

    mvn spring-boot:run

Access the application at http://localhost:8080.


Future Enhancements
- Security: Add authentication and authorization.

