# Interactive Pattern Navigator

Explore, compare, and visualize **Software & Data Engineering patterns** in one unified, interactive platform.  
This project helps you understand not just *what* a pattern is, but *when*, *why*, and *how* to use it in real systems.

> Built with **Spring Boot**, **Microservices**, **MVC**, **Service Discovery (Eureka)**, **API Gateway**, **MongoDB**, and an **AI Pattern-Recommendation Agent**.

---

## Why this project?

Selecting the right architecture or design pattern is tricky. Most people know definitions, but not the trade-offs.

**Interactive Pattern Navigator** closes the gap by providing:

- Linked relationships among patterns (e.g., Broker ↔ Pub/Sub ↔ SOA)
- Quality-attribute impact (availability, performance, scalability, security)
- Anti-patterns and migration paths (Monolith → Microservices)
- A problem-solver powered by an AI agent
- Side-by-side comparison of tactics with examples

---

## Core Features

### Pattern Explorer
Browse patterns with:
- Definitions  
- When to use / when not to use  
- Tactics  
- Pros and cons  
- Related patterns  
- Real-world examples

### AI-powered Problem Solver
Enter an architectural problem and the AI agent:
- Suggests the most relevant pattern(s)
- Provides supporting patterns
- Highlights anti-patterns to avoid
- Explains quality attribute impacts

### Pattern Detail View
Each pattern includes:
- Context
- Example scenarios
- Trade-offs
- Similar patterns
- Implementation snippets

---

## How to Start the Application

1. Clone the repository.
2. Start the Service Discovery (Eureka) at `http://localhost:8761/`.
3. Start the API Gateway on port **9090**.
4. Run multiple instances of the Pattern Catalog service on ports:
   - `8081`
   - `8082`
   - `8083`
5. Open the UI and start exploring patterns or submit a problem to the AI agent.

## Access the project

Open `http://localhost:9090/`
---

# Architecture

<img width="890" height="637" alt="image" src="https://github.com/user-attachments/assets/ba77697b-bca7-4c76-a6f6-4b575e9ac30f" />

---

## Patterns Included (initial list)

1. **Broker Pattern**  
   Ideal for distributed systems requiring decoupled communication and message routing.

2. **Model–View–Controller (MVC)**  
   Used in the Spring application:
   - **Model:** Pattern objects  
   - **View:** Thymeleaf HTML templates  
   - **Controller:** Spring Controllers  
   Benefits: Strong separation of concerns and easy UI extension.

3. **Layered Architecture**  
   Separates responsibilities into Presentation, Business Logic, and Data layers.

<img width="736" height="714" alt="image" src="https://github.com/user-attachments/assets/a81840b2-8094-4c95-b250-892583f2a0cd" />

---

## Quality Attributes Addressed

The app itself is designed to address the following attributes:

- Availability  
- Scalability  
- Performance  
- Security (not rolled out)



---

## Technology Stack

- **Java / Spring Boot** Microservices  
- **Thymeleaf** templates  
- **MongoDB Atlas** DB  
- **Eureka** Service Discovery  
- **API Gateway**  
- **AI Agent** for pattern recommendations  
- **Load-balanced microservices**

---

## Future Enhancements

- Interactive pattern-relationship graph 
- Versioned pattern definitions
- Pattern critique via LLM integration
- PDF export for patterns
- Decision simulator to visualize trade-offs dynamically

---

## Project Vision

To become a **unified architectural decision-support system**, enabling students, engineers, and architects to explore patterns, validate decisions, and understand real-world trade-offs in seconds.

---

