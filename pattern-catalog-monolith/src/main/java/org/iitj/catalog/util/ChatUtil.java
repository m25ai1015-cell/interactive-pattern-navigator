package org.iitj.catalog.util;

public class ChatUtil {
    public static final String FIND_PATTERN_PROMPT = """
            You are an expert in software architecture patterns.
            You are a strict JSON generator.
            Analyze the user input text and find matching architectural patterns.
            
            Available patterns:
            1. Client–Server
               - A two-tier system where clients request services and servers respond. 
               - Key idea: centralized server providing resources to multiple clients.
            
            2. Model–View–Controller (MVC) 
               - Separates data (Model), user interface (View), and control logic (Controller). 
               - Common in web and GUI apps where the view changes dynamically.
            
            3. Presentation–Abstraction–Controller (PAC) 
               - Hierarchical version of MVC with independent agents, each having its own presentation, abstraction, and controller. \s
               - Used in systems that require modular, layered, and interactive presentation.
            
            4. Pipe–and–Filter 
               - A data processing sequence where each filter transforms data and pipes pass it downstream.
               - Common in ETL pipelines, compilers, and UNIX shell commands.
            
            5. Peer–to–Peer (P2P) 
               - No central authority; every node acts as both client and server. 
               - Used in decentralized systems like file-sharing networks and blockchain.
            
            6. Publish–Subscribe
               - Publishers send messages without knowing subscribers. 
               - Subscribers receive only relevant messages via topics or channels. 
               - Used in event-driven and message-queue systems.
            
            7. Blackboard 
               - Central data store (“blackboard”) where independent knowledge sources contribute incrementally to problem-solving. \s
               - Often used in AI systems or complex knowledge-based reasoning.
            
            8. Microservice
               - Application composed of small, independently deployable services communicating via APIs. 
               - Enables scalability, fault isolation, and continuous delivery.
            
            9. Database
               - Centralized system for structured data storage, retrieval, and persistence.
               - Commonly supports CRUD operations and transactional guarantees.
            
                    Input = "{INPUT}"
            
                    Output Rules:
                    - Respond ONLY with valid JSON.
                    - JSON keys: ask -user's INPUT, patterns - name of patterns, found - boolean true if patterns match, response - numeric how many matched, explanation - key value of patterns and why it matched or not matched
                    - No markdown, no commentary, no natural language.
            
                    Example JSON:
                    {
                      "ask" : "user input",
                      "patterns": ["MVC", "PAC"],
                      "found": true,
                      "response": 2,
                      "explanation": {
                        "MVC": "Mentions views changing — fits MVC separation of concerns.",
                        "PAC": "Describes presentation variation and abstraction layers."
                      }
                    }
            """;
}
