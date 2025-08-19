# Contact Management System – Java Spring Boot Assessment

## Difficulty Level
Beginner

## Duration
30 minutes

## Type
Assessment Project

## What you will learn
By the end of this, you will be able to:
- Create a RESTful API for contact management without using entity relationships
- Implement basic Create and Read operations using HTTP methods (POST and GET)
- Handle validation and error responses effectively
- Implement proper exception handling
- Work with in-memory H2 database

## What you will be provided
- Boilerplate code to develop the complete system
- The boilerplate code is available in the lab Desktop > Project folder
- Instructions to guide you through the assessment tasks
- A Java development environment pre-configured for you to start coding immediately

## What you need to know
- Knowledge of Java programming language
- Understanding of Spring Boot
- Experience with RESTful API development
- Basic understanding of data validation

## Skill Tags
- Java
- Spring Boot
- H2 Database
- REST API
- Data Validation

## What you will do
You have been assigned to develop a Contact Management System using Java Spring Boot. Your goal is to build a RESTful API that allows users to manage contacts efficiently. The API will enable adding new contacts and retrieving contact information. The application will use an in-memory database (H2) to store contact data. The implementation must handle both success and failure cases, ensuring appropriate messages are returned for each API operation.

## Objectives
- Implement API endpoints for POST and GET operations on contacts
- Ensure proper validation of contact information
- Handle both success and failure cases with appropriate messages
- Implement global exception handling
- Configure and use H2 in-memory database

## Activities

### 1. Important to Note
- You are provided with boilerplate code in the Project folder
- The boilerplate code contains necessary instructions to develop the complete system
- Do not modify the Default Code blocks given in the boilerplate code
- Open the Project folder in your Java IDE to develop the code

### 2. Define the ContactController Class
Import Required Packages:
- Import necessary classes like Contact, ContactService, and ContactValidationException
- Import validation annotations from jakarta.validation package

Annotate the Controller:
- Use @RestController to define the class as a controller
- Use @RequestMapping("/api/contacts") to map all API requests

Inject ContactService:
- Use @Autowired to inject the ContactService class

### 3. Implement API Endpoints
Get All Contacts:
- Define a @GetMapping method to retrieve all contacts
- Return an appropriate response when no contacts are found

Add a New Contact:
- Define a @PostMapping method to add a new contact
- Validate the input request using @Valid annotation
- Return a success response with the created contact details

### 4. Exception Handling
Implement Global Exception Handler:
- Create GlobalExceptionHandler class with @RestControllerAdvice
- Handle validation exceptions and return proper error messages
- Implement custom exception handling for business logic errors

### 5. Configure Database Properties
Application Properties:
```properties
spring.datasource.url=jdbc:h2:mem:contactdb
spring.datasource.username=sa
spring.datasource.password=Root123$
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
```

### 6. Contact Entity
Fields and Validation Messages:
```java
name:
@NotBlank(message = "Name is required")

phone:
@NotBlank(message = "Phone number is required")
@Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")

email:
@NotBlank(message = "Email is required")
@Email(message = "Invalid email format")

id:
Auto-generated using @GeneratedValue
```

### 7. Test the API Endpoints
Use Postman:
- Create a Postman collection to test all API endpoints
- Test each operation with various inputs (valid and invalid)
- Verify error handling and validation responses

## Test Cases

### Get All Contacts
Test Case 1:
- Scenario: Retrieve all contacts when contacts exist in database
- Expected Result: List of contacts is returned with 200 OK status

Test Case 2:
- Scenario: Retrieve all contacts when database is empty
- Expected Result: Empty list is returned with 200 OK status

### Create Contact
Test Case 1:
- Scenario: Create contact with valid data
- Expected Result: Contact is created and returned with 201 Created status

Test Case 2:
- Scenario: Create contact with invalid email
- Expected Result: 400 Bad Request with error message "Invalid email format"

Test Case 3:
- Scenario: Create contact with invalid phone number
- Expected Result: 400 Bad Request with error message "Phone number must be 10 digits"

Test Case 4:
- Scenario: Create contact with missing required fields
- Expected Result: 400 Bad Request with appropriate validation messages

## Sample Valid Request
```json
{
    "name": "John Doe",
    "phone": "9449651424",
    "email": "john.doe@example.com"
}
```

## Success Response
```json
{
    "id": 1,
    "name": "John Doe",
    "phone": "9449651424",
    "email": "john.doe@example.com"
}
```

## Error Response
```json
{
    "timestamp": "2023-05-27T10:00:00.000+00:00",
    "status": 400,
    "errors": {
        "email": "Invalid email format",
        "phone": "Phone number must be 10 digits"
    }
}
```

---
*Note: This assessment tests your ability to implement basic CRUD operations, handle validations, and manage exceptions in a Spring Boot application.*
