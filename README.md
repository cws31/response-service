# Emergency Response Service

A microservice-based backend component for emergency management systems, built with **Spring Boot**. The **Response Service** manages emergency response teams, tracking their status, type, and dispatch workflows to ensure fast, reliable coordination during critical situations.

---

## Features

* **Team Management**: Register, update, and monitor emergency response teams.
* **Status & Type Tracking**: Categorize teams by type and monitor operational status (e.g., available, dispatched).
* **Dispatch Operations**: Handle team dispatch requests and status transitions seamlessly.
* **Robust Exception Handling**: Centralized global error handling ensuring clear, standard error response formats.

---

## Tech Stack

* **Language**: Java
* **Framework**: Spring Boot
* **Build Tool**: Maven (`mvnw`)
* **Database / Persistence**: Spring Data JPA

---

##  Project Structure

```text
response-service/
├── src/
│   ├── main/java/com/emergency/response_service/
│   │   ├── controller/     # REST Controllers (ResponseTeamController)
│   │   ├── dto/            # Data Transfer Objects (Requests/Responses)
│   │   ├── entity/         # JPA Entities (ResponseTeam)
│   │   ├── enums/          # Status and Type Enumerations
│   │   ├── exception/      # Global exception handlers & custom errors
│   │   ├── repository/     # Spring Data JPA Repositories
│   │   ├── service/        # Business logic & implementation classes
│   │   └── ResponseServiceApplication.java
│   └── resources/
│       └── application.properties
└── pom.xml
