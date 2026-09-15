# Emergency Response Service

A microservice-based backend component for emergency management systems, built with **Spring Boot** and **Spring Cloud**. The **Response Service** manages emergency response teams, tracks their status, and communicates with external microservices (such as the Incident Service) via **OpenFeign** to ensure fast, reliable coordination during critical situations.

---

## Features

* **Team Management**: Register, update, and monitor emergency response teams.
* **Status & Type Tracking**: Categorize teams by type and monitor operational status (e.g., available, dispatched).
* **Inter-Service Communication**: Seamlessly fetches and synchronizes incident information using Spring Cloud OpenFeign.
* **Dispatch Operations**: Handle team dispatch requests and status transitions seamlessly.
* **Robust Exception Handling**: Centralized global error handling ensuring clear, standard error response formats.

---

## Tech Stack

* **Language**: Java 21
* **Framework**: Spring Boot & Spring Cloud (OpenFeign)
* **Build Tool**: Maven (`mvnw`)
* **Database / Persistence**: Spring Data JPA

---

## Project Structure

```text
response-service/
├── src/
│   ├── main/java/com/emergency/response_service/
│   │   ├── client/         # OpenFeign client interfaces & client DTOs
│   │   │   ├── dto/        # Incident DTOs & Enums (IncidentResponse, Category, Severity, Status)
│   │   │   └── IncidentClient.java
│   │   ├── controller/     # REST Controllers (ResponseTeamController, IncidentCommunicationController)
│   │   ├── dto/            # Local Data Transfer Objects
│   │   ├── entity/         # JPA Entities (ResponseTeam)
│   │   ├── enums/          # Status and Type Enumerations
│   │   ├── exception/      # Global exception handlers & custom errors
│   │   ├── repository/     # Spring Data JPA Repositories
│   │   ├── service/        # Business logic & implementation classes
│   │   └── ResponseServiceApplication.java
│   └── resources/
│       └── application.properties
└── pom.xml