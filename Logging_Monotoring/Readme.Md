Logging & Monitoring - Spring Boot
Project Overview

This project demonstrates Logging and Monitoring in a Spring Boot application using SLF4J and Logback. It includes centralized logging, audit logging for API requests, JWT-based authentication, and global exception handling.

Features
Centralized logging using SLF4J and Logback
Audit logging for API requests
JWT Authentication and Authorization
Spring Security integration
Global exception handling
H2 in-memory database
REST APIs for User Registration and Login
Clean layered architecture
Technology Stack
Java 17
Spring Boot 3
Spring Security
Spring Data JPA
H2 Database
JWT (JSON Web Token)
SLF4J
Logback
Maven
Project Structure
src/main/java/jwtsecurity
│
├── config
│   ├── JwtUtil.java
│   ├── JwtAuthFilter.java
│   └── SecurityConfig.java
│
├── controller
│   └── AuthController.java
│
├── dto
│   ├── LoginRequest.java
│   └── RegisterRequest.java
│
├── entity
│   ├── User.java
│   └── Role.java
│
├── exception
│   ├── CustomException.java
│   └── GlobalExceptionHandler.java
│
├── filter
│   └── AuditLoggingFilter.java
│
├── repository
│   └── UserRepository.java
│
├── service
│   ├── UserService.java
│   └── UserDetailsServiceImpl.java
│
└── JwtSecurityApplication.java
Configuration
application.properties
server.port=8080

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

logging.level.root=INFO
logging.level.jwtsecurity=DEBUG
logging.file.name=logs/application.log
Running the Application
Clone Repository
git clone <repository-url>
cd jwtsecurity
Build Project
.\mvnw.cmd clean package
Run Project
java -jar target/jwtsecurity-0.0.1-SNAPSHOT.jar

Or

.\mvnw.cmd spring-boot:run
API Endpoints
Register User

POST

http://localhost:8080/auth/register

Request Body:

{
  "username": "john",
  "password": "12345",
  "role": "USER"
}

Response:

User registered successfully
Login User

POST

http://localhost:8080/auth/login

Request Body:

{
  "username": "john",
  "password": "12345"
}

Response:

JWT Token
Audit Logging

Audit logs are generated for every API request using AuditLoggingFilter.

Example:

INFO Request Started | Method=POST URI=/auth/register
INFO Request Completed | Status=200 Duration=145ms
Exception Handling

Global exception handling is implemented using GlobalExceptionHandler.

Example:

Username already exists
Username cannot be empty
Password cannot be empty
Log File

Application logs are stored in:

logs/application.log
Testing

The APIs were tested using Thunder Client/Postman.

Assignment Requirements Covered
Implement centralized logging in Spring Boot
Use SLF4J and Logback
Create audit logs for API requests
Handle application exceptions
Follow clean coding practices
Add proper project documentation
