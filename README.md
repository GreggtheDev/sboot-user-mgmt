# User Management System

## Overview

This project is a Spring Boot application that implements a user management system with features such as user registration, authentication (with JSON Web Tokens - JWT), and role-based access control. The project also provides a basic web interface using Thymeleaf for user registration and management.

### Features
- User Registration with validation
- Stateless authentication using JWT
- Role-based access control (ADMIN and USER)
- Database management with Spring Data JPA
- Basic web interface with Thymeleaf
- RESTful API for user management
- Exception handling with custom error responses

## Requirements

- Java 17 or higher
- Maven 3.6+ 
- IntelliJ IDEA (or any other Java IDE)
- H2 Database (embedded for simplicity)
- Postman (optional, for testing the API)
- Web browser (for testing Thymeleaf web interface)

## Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/user-management-system.git
cd user-management-system
```

### 2. Build the Project
Ensure Maven is installed and working. Navigate to the project directory and run:
```bash
mvn clean install
```

### 3. Run the Application
```bash
mvn spring-boot:run
```

### 4. Access the Application
Once the application starts, you can access:
- **API Endpoints**: `http://localhost:8080/api`
- **Thymeleaf Web Interface**: `http://localhost:8080/`

### API Endpoints

#### 1. Authentication
- **Register**: `POST /api/auth/register`
  - Request Body:
    ```json
    {
      "username": "user123",
      "email": "user@example.com",
      "password": "password123"
    }
    ```
  - Response: `200 OK` on successful registration

- **Login**: `POST /api/auth/login`
  - Request Body:
    ```json
    {
      "username": "user123",
      "password": "password123"
    }
    ```
  - Response: `200 OK` with JWT token

#### 2. User Management (Secured with JWT)
- **Get All Users (Admin Only)**: `GET /api/users`
- **Get User by ID (Admin or Self)**: `GET /api/users/{id}`
- **Update User (Admin or Self)**: `PUT /api/users/{id}`
- **Delete User (Admin Only)**: `DELETE /api/users/{id}`

### Web Interface (Thymeleaf)
The web interface can be accessed at `http://localhost:8080/`. It allows:
- User registration through a form.
- Admins to manage users (view, update, delete).

## Configuration

### Database Configuration
The application uses an in-memory H2 database by default. You can configure a persistent database by modifying the `application.properties` file.

#### Default H2 Configuration:
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
```

To access the H2 console, navigate to `http://localhost:8080/h2-console`. The default credentials are:
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: `password`

### Security Configuration
The application uses JWT for stateless authentication. After login, a JWT token is provided, which needs to be included in the `Authorization` header for all secured API requests.

#### Example Authorization Header:
```
Authorization: Bearer <JWT_TOKEN>
```

### Roles
There are two predefined roles:
- **USER**: Can view and update their own user details.
- **ADMIN**: Can manage all users (create, read, update, delete).

### Exception Handling
The application uses a global exception handler (`@ControllerAdvice`) to handle exceptions such as user not found or validation errors. Responses include meaningful error messages and appropriate HTTP status codes.

## Project Structure

```
src/main/java
│
├── com.example.usermanagement
│   ├── config          # Spring Security and JWT configuration
│   ├── controller      # API controllers for authentication and user management
│   ├── dto             # Data Transfer Objects for user registration/login
│   ├── entity          # JPA entities (User)
│   ├── exception       # Custom exceptions and global exception handler
│   ├── repository      # Spring Data JPA repositories
│   └── service         # Business logic for user management and JWT handling
│
└── resources
    ├── templates       # Thymeleaf templates (HTML files for registration and user management)
    ├── static          # Static resources (CSS, JS)
    ├── application.properties # Configuration file for DB, security, etc.
```

## Running Tests

To run the tests, use the following Maven command:
```bash
mvn test
```

## Future Improvements
- Add email verification during registration.
- Implement password reset functionality.
- Add unit and integration tests for comprehensive coverage.
- Extend the web interface to allow full user management through the browser.
  
## License
This project is licensed under the MIT License. Feel free to fork, modify, and use in your own projects.
