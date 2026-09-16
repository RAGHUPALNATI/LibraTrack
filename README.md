# LibraTrack — Library Management API

A Spring Boot REST API built while learning backend development.

## Tech Stack
- Java 21
- Spring Boot X.X.x
- Spring Data JPA
- MySQL
- Lombok

## Phases
- ✅ Phase 1 — Basic CRUD (Book entity)
- ⏳ Phase 2 — Search and Filter
- ⏳ Phase 3 — Relationships (Author entity)

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/books | Create a book |
| GET | /api/books | Get all books |
| GET | /api/books/{id} | Get book by id |
| PUT | /api/books/{id} | Update a book |
| DELETE | /api/books/{id} | Delete a book |

## How to Run
1. Create MySQL database: `CREATE DATABASE bookapi;`
2. Update `application.properties` with your MySQL password
3. Run `BookapiApplication.java`
4. API runs on `http://localhost:8080`