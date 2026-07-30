<img width="1024" height="1536" alt="full credence Bsckend" src="https://github.com/user-attachments/assets/85e9b2c5-d325-4acd-8b3d-966baa9d717e" /># 🏥 CREDENCE 2.0
### AI-Powered Clinical Report Generation System

> A secure Spring Boot backend application that converts patient conversations into structured clinical reports using Groq AI while protecting every endpoint with JWT Authentication and Spring Security.

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.x-6DB33F?style=for-the-badge&logo=springboot)
![Spring Security](https://img.shields.io/badge/Spring_Security-JWT-success?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge&logo=mysql)
![Hibernate](https://img.shields.io/badge/Hibernate-ORM-brown?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven)
![Status](https://img.shields.io/badge/Status-Active-brightgreen?style=for-the-badge)

---

# 📌 Table of Contents

- Project Overview
- Features
- Technology Stack
- System Architecture
- Workflow
- Project Structure
- Database Design
- Screenshots
- API Endpoints
- Installation
- Security
- Future Enhancements
- Author

---

# 🚀 Project Overview

CREDENCE 2.0 is a secure backend application developed using **Spring Boot**, **Spring Security**, **JWT Authentication**, **Hibernate**, and **MySQL**.

The system allows authenticated users to generate structured clinical reports manually or by sending patient conversations to **Groq AI**, which extracts medical information and returns organized clinical data.

The generated reports are securely stored in MySQL and are accessible only to their respective owners.

---

# ✨ Features

- 🔐 JWT Authentication
- 🛡 Spring Security Filter Chain
- 🔒 BCrypt Password Encryption
- 🤖 Groq AI Report Generation
- 📋 Manual Report Creation
- 📁 Per-user Report History
- 💾 MySQL Database Storage
- ⚡ REST APIs
- 📦 Maven Project
- 🏗 Layered Architecture
- 🔄 JSON-based Clinical & Biometric Data
- 👤 Secure User Authorization

---

# 💻 Technology Stack

| Technology | Purpose |
|------------|----------|
| Java 21 | Programming Language |
| Spring Boot | Backend Framework |
| Spring Security | Authentication & Authorization |
| JWT | Stateless Authentication |
| Hibernate / JPA | ORM |
| MySQL | Database |
| Maven | Dependency Management |
| Groq AI | AI Report Generation |
| IntelliJ IDEA | IDE |
| Postman | API Testing |

---

# 🏗 System Architecture

```text
                Client

                  │

                  ▼

         Spring Boot REST API

                  │

          Spring Security

          JWT Authentication

                  │

            Report Service

         ┌────────┴────────┐

         ▼                 ▼

     Groq AI            MySQL

         │                 │

         └──────► Clinical Report
```

---

# 🔄 Application Workflow

```text
User Registration

        │

User Login

        │

Receive JWT Token

        │

Bearer Token Authentication

        │

Generate Report

        │

Groq AI Processes Data

        │

Clinical Report Generated

        │

Save into MySQL

        │

Retrieve User Reports
```

---

# 📂 Project Structure

```text
src
 └── main
      ├── java
      │     └── com.cfs.CREDENCE_20
      │            ├── controller
      │            ├── dto
      │            ├── Entity
      │            ├── repository
      │            ├── security
      │            ├── service
      │            └── Application.java
      │
      └── resources
            └── application.properties
```

---

# 🗄 Database Design

- **Users Table**
  - id
  - full_name
  - email
  - password
  - uid
  - created_at

- **Reports Table**
  - id
  - clinical_data
  - biometric_data
  - objective_summary
  - created_at
  - user_id

Relationship

```
One User
      │
      │
      ▼
Many Reports
```

---

# 📸 Screenshots

## Overview


<img width="1024" height="1536" alt="full credence Bsckend" src="https://github.com/user-attachments/assets/5f1949eb-39a7-41f9-8dfa-14d15287773c" />



---

## Project Structure

![Project Structure](assets/project-structure.png)

---

## Register API

![Register](assets/register-api.png)

---

## JWT Authentication

![JWT](assets/jwt-token1.png)

---

## Application Running

![Running](assets/application-running.png)

---

## Database Schema

![Database](assets/database-schema.png)

---

# 📮 REST API

## Authentication

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | /api/v1/auth/register | Register User |
| POST | /api/v1/auth/login | Login User |

---

## Reports

| Method | Endpoint |
|---------|----------|
| POST | /api/v1/reports |
| GET | /api/v1/reports |

---

# 🔐 Security

The application uses **Spring Security** with **JWT Authentication**.

Workflow

1. User registers.
2. Password stored using BCrypt.
3. User logs in.
4. JWT Token generated.
5. Client sends Bearer Token.
6. JWT Filter validates token.
7. Authorized request reaches Controller.
8. Data saved into MySQL.

---

# ⚙ Installation

Clone Repository

```bash
git clone https://github.com/Ankitraj1124/Credence-2.0.git
```

Move into project

```bash
cd Credence-2.0
```

Configure MySQL inside

```
application.properties
```

Run

```bash
mvn spring-boot:run
```

Application starts on

```
http://localhost:8080
```

---

# 🔮 Future Enhancements

- OAuth2 Authentication
- Refresh Tokens
- Docker Support
- Swagger Documentation
- Redis Token Blacklisting
- Email Verification
- CI/CD Pipeline
- Cloud Deployment

---

# 👨‍💻 Author

## Ankit Raj

**Java Backend Developer**

**Tech Stack**

- Java
- Spring Boot
- Spring Security
- JWT
- Hibernate
- MySQL
- REST APIs
- Groq AI

GitHub

https://github.com/Ankitraj1124

---

# ⭐ If you found this project useful, don't forget to Star the repository.ving it a **Star**.
