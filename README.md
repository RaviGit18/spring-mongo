# Spring Boot MongoDB Application

A Spring Boot application that demonstrates integration with MongoDB database for managing a book catalog system.

## Overview

This project provides a RESTful API for performing CRUD operations on a book collection stored in MongoDB. It includes functionality to add, retrieve, update, and delete books with various attributes such as book ID, ISBN number, category, and name.

## Technology Stack

- **Java 17**
- **Spring Boot 3.4.3**
- **Spring Data MongoDB**
- **Spring Web**
- **Maven**

## Project Structure

```
src/
├── main/
│   ├── java/com/example/mongo/
│   │   ├── MongoApplication.java          # Main application class
│   │   ├── controller/
│   │   │   └── BookController.java        # REST API endpoints
│   │   ├── entity/
│   │   │   └── Book.java                  # Book entity model
│   │   ├── repository/
│   │   │   └── BookRepository.java        # MongoDB repository
│   │   └── service/
│   │       └── BookService.java           # Business logic layer
│   └── resources/
│       └── application.properties         # Application configuration
└── test/
    └── java/com/example/mongo/
        └── MongoApplicationTests.java     # Test classes
```

## Database Configuration

The application connects to a MongoDB instance with the following configuration:

- **Host**: localhost
- **Port**: 27017
- **Database**: book

Make sure MongoDB is running on your local machine before starting the application.

## API Endpoints

### Get All Books
- **URL**: `/getAllBooks`
- **Method**: GET
- **Description**: Retrieves all books from the database
- **Response**: List of Book objects

### Get Books by Category
- **URL**: `/getBook`
- **Method**: GET
- **Parameters**: `category` (String)
- **Description**: Retrieves books filtered by category
- **Response**: List of Book objects matching the specified category

### Get Book by ID
- **URL**: `/getBookById`
- **Method**: GET
- **Parameters**: `bookId` (long)
- **Description**: Retrieves a specific book by its ID
- **Response**: Single Book object

### Add New Book
- **URL**: `/addBook`
- **Method**: GET
- **Parameters**: 
  - `bookId` (long)
  - `isbnNumber` (String)
  - `bookName` (String)
  - `category` (String)
- **Description**: Adds a new book to the database
- **Response**: Success message

### Delete Book
- **URL**: `/deleteBook`
- **Method**: GET
- **Parameters**: `bookId` (int)
- **Description**: Deletes a book by its ID
- **Response**: Success message

## Book Entity

The Book entity contains the following fields:

- `id`: MongoDB document ID (auto-generated)
- `bookId`: Unique book identifier (long)
- `isbnNumber`: ISBN number of the book (String)
- `category`: Book category (String)
- `bookName`: Name of the book (String)

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- MongoDB instance running on localhost:27017

## Installation and Running

1. **Clone the repository** (if using version control)

2. **Navigate to the project directory**:
   ```bash
   cd spring-mongo
   ```

3. **Build the project**:
   ```bash
   mvn clean install
   ```

4. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

   The application will start on `http://localhost:8080`

## Testing

Run the test suite using Maven:
```bash
mvn test
```

## Usage Examples

### Add a new book:
```
GET http://localhost:8080/addBook?bookId=1&isbnNumber=978-3-16-148410-0&bookName=Spring%20Boot%20Guide&category=Programming
```

### Get all books:
```
GET http://localhost:8080/getAllBooks
```

### Get books by category:
```
GET http://localhost:8080/getBook?category=Programming
```

### Get book by ID:
```
GET http://localhost:8080/getBookById?bookId=1
```

### Delete a book:
```
GET http://localhost:8080/deleteBook?bookId=1
```

## Configuration

The MongoDB connection settings can be modified in `src/main/resources/application.properties`:

```properties
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=book
```