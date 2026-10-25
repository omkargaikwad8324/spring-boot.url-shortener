# Spring Boot URL Shortener

A URL Shortener application built with Java 21 and Spring Boot, designed to convert long URLs into short links and redirect users to their original destinations.

## Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA / Hibernate
- PostgreSQL
- Flyway Database Migrations
- Maven
- Docker and Docker Compose

## Features

- Short URL generation
- Redirect from short links to original URLs
- PostgreSQL database integration
- Database schema versioning with Flyway
- Containerized database setup with Docker Compose

## Prerequisites

- JDK 21
- Maven or the included Maven Wrapper
- Docker Desktop
- Git

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/omkargaikwad8324/spring-boot.url-shortener.git
   cd spring-boot.url-shortener
   ```

2. Configure your PostgreSQL connection in `application.properties` or environment variables.

3. Start the database using Docker Compose:

   ```bash
   docker compose up -d
   ```

4. Run the Spring Boot application:

   Windows:

   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

   Or, if Maven is installed:

   ```bash
   mvn spring-boot:run
   ```

5. Open the application at `http://localhost:8080`, subject to your configured port and routes.

## API Documentation

Document the actual endpoints implemented in the project, including:

- Endpoint for creating a short URL
- Endpoint for redirecting to the original URL
- Request and response examples

## Database Migrations

Flyway migration scripts are maintained in the project's resources directory. Configure the database and migration baseline appropriately before running the application against an existing database.

## License

Add a license if you intend to distribute the project under specific reuse terms.
