# Task Management System

This is a simple task management system built with Spring Boot and Lombok. It allows you to create, update, delete, and retrieve tasks. It does not use a database, instead, it uses a List to store tasks.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java 8 or higher
- Maven

### Installing

1. Clone the repository
```
git clone https://github.com/yourusername/task-management-system.git
```

2. Navigate to the project directory
```
cd task-management-system
```

3. Build the project
```
./mvnw clean install
```

4. Run the application
```
./mvnw spring-boot:run
```

The application will start and listen on `http://localhost:8080`.

## Usage

The application exposes the following endpoints:

- `POST /tasks`: Create a new task
- `GET /tasks`: Retrieve all tasks
- `GET /tasks/{id}`: Retrieve a task by id
- `PUT /tasks/{id}`: Update a task
- `DELETE /tasks/{id}`: Delete a task

## Running the tests

To run the unit tests, use the following command:

```
./mvnw test
```

## Built With

- [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
- [Lombok](https://projectlombok.org/) - Java library that automatically plugs into your editor and build tools, spicing up your java.

## Authors

- Your Name

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

- Hat tip to anyone whose code was used
- Inspiration
- etc.