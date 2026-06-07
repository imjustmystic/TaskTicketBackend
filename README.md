# TaskTicket Backend (Spring Boot REST API)

A backend REST API built using **Java + Spring Boot** for managing users and tasks with relational database design, ownership rules, and real-world backend architecture patterns.

---

## Overview

TaskTicket is a simple but scalable task management backend that demonstrates:

- RESTful API design
- Layered architecture (Controller → Service → Repository)
- JPA relationships (One-to-Many)
- Data ownership and integrity rules
- Basic backend security considerations
- H2 in-memory database for development

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA (Hibernate)
- H2 Database
- Maven
- Postman (for testing)

---

## Features Implemented

### User Management
- Create user
- Get all users
- Delete user
- Cascade delete tasks when user is deleted

### Task Management
- Create task for a specific user
- Get all tasks
- Get tasks by user ID
- Get specific task by user ID
- Delete task with ownership validation

---

## Database Relationships

### One-to-Many Relationship

User (1) ────────> (Many) Tasks

- One user can have multiple tasks
- Each task belongs to exactly one user
- Cascade delete enabled (deleting a user deletes their tasks)

---

## API Endpoints

### Users

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/users` | Get all users |
| POST | `/users` | Create a user |
| DELETE | `/users/{id}` | Delete a user |

---

### Tasks

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/tasks` | Get all tasks |
| GET | `/users/{userId}/tasks` | Get tasks for a user |
| GET | `/users/{userId}/tasks/{taskId}` | Get specific task |
| POST | `/users/{userId}/tasks` | Create task for user |
| DELETE | `/users/{userId}/tasks/{taskId}` | Delete task with ownership check |

---

## Data Integrity Rules
- A task must belong to a user
- A user cannot access or delete another user’s tasks
- Cascade delete ensures no orphan tasks remain
- Invalid operations return proper error responses

---

### Author

Built by Manogna Raju Chamarthi

Backend Developer in progress | Java | Spring Boot | System Design Learner

If you like this project, consider giving it a ⭐ on GitHub
