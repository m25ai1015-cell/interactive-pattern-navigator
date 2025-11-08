# Interactive Pattern Navigator

Explore, compare, and visualize **Software & Data Engineering** patterns—side-by-side.  
See relationships, trade-offs, tactics, and anti-patterns in an interactive, web-based platform.

> Built with **Microservices + MVC + Load Balancer + service Discovery**, **AI Agent**,**Spring Boot**, **HTML/CSS**, and **MongoDB**.

---

## Why this project?

Learners and practitioners often know *what* a pattern is, but not *when* and *why* to choose it.  
**Interactive Pattern Navigator** bridges theory and practice by showing:
- Relationships among patterns (e.g., Broker ↔ Pub/Sub ↔ SOA).
- Quality-attribute trade-offs (latency, availability, security, modifiability).
- Common anti-patterns and migration paths (e.g., Monolith → Microservices).
- Live comparisons with examples, code snippets, and decision checklists.

---

## Core Features

- **Pattern Explorer**: Browse patterns with definitions, diagrams, pros/cons, tactics, and examples.
- **Problem Solver View**: Enter an architectural problem and search. The system uses Ai agents to find relevant patterns.
- **Pattern View**: Shows a pattern's details, simialr patterns, context when to use, when not to use etc.


---

## How To Start the Application

- Clone the repository
- Run the Service Discoery (Eureka project first) (starts at http://localhost:8761/) 
- Run the API gateway project (starts at [9090](http://localhost:9090/))
- Run multiple instances of the main pattern catalog project (http://localhost:8081, http://localhost:8082, ...)


# Architecture 
<img width="890" height="637" alt="image" src="https://github.com/user-attachments/assets/ba77697b-bca7-4c76-a6f6-4b575e9ac30f" />

## Patterns
1. Broker
2. MVC
3. Layered 
<img width="736" height="714" alt="image" src="https://github.com/user-attachments/assets/a81840b2-8094-4c95-b250-892583f2a0cd" />







