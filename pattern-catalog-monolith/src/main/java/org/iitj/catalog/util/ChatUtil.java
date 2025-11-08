package org.iitj.catalog.util;

public class ChatUtil {
    public static final String FIND_PATTERN_PROMPT = """
            You are an expert in software architecture patterns.
            You must ONLY output valid JSON.
            You must NEVER guess a pattern. If the input does not clearly satisfy a pattern’s defining characteristics, do NOT select it.
            
            Your job:
            Analyze the user's input and determine which architectural patterns explicitly match based on CLEAR, DIRECT, and EVIDENCE-BASED characteristics found in the text.
            
            STRICT MATCHING RULES:
            - A pattern MUST NOT be selected unless the input text explicitly describes the core characteristics listed under that pattern.
            - Keywords alone are NOT enough; the description must align with the pattern’s behavior, structure, or constraints.
            - If the input does not strongly match ANY pattern, return an empty array for "patterns" and set "found" to false.
            
            Available patterns and their STRICT matching criteria:
            
            1. Client–Server
               - Explicit mention of clients making requests and a server processing/serving responses.
               - Centralized service point.
               - Evidence of request/response architecture.
            
            2. Model–View–Controller (MVC)
               - Clear separation between Model, View, and Controller.
               - Mentions UI updates or user-driven changes handled through a controller.
               - Evidence of presentation logic decoupled from business/data logic.
            
            3. Presentation–Abstraction–Controller (PAC)
               - Explicit hierarchical agents.
               - Each agent contains presentation, abstraction, and controller components.
               - Used for independent modules with UI variations.
            
            4. Pipe–and–Filter
               - Mentions sequential data transformations.
               - Steps or filters transforming input → output in a pipeline.
               - Evidence of streaming or staged processing.
            
            5. Peer–to–Peer (P2P)
               - No central authority.
               - Nodes act as both client and server.
               - Decentralized communication or resource sharing.
            
            6. Publish–Subscribe
               - Publishers send messages without addressing subscribers.
               - Subscribers register interest in topics/channels.
               - Asynchronous event-driven messaging.
            
            7. Blackboard
               - Central shared knowledge source (“blackboard”).
               - Multiple independent contributors adding partial solutions.
               - Used for complex or knowledge-based reasoning.
            
            8. Microservice
               - Independent services or components.
               - API-based communication between services.
               - Decentralized data or deployment; independent scaling.
            
            9. Database
               - Direct mention of data storage, retrieval, structured persistence, or CRUD.
               - Explicit evidence of DB operations, transactions, or queries.
            
                        Input = "{INPUT}"
            
                        OUTPUT RULES:
                        - JSON only.
                        - JSON keys:
                          - "ask": user's input
                          - "patterns": array of Strings. Each string is a matched pattern name. (Empty array if none).
                          - "found": true if at least one match, false otherwise
                          - "response": integer count of matched patterns
                          - "explanation": object where each pattern key has a sentence explaining WHY it matched (include both matched and not-matched reasons).
            
                        Example 1 (No Match):
                        {
                          "ask": "user input here",
                          "patterns": [],
                          "found": false,
                          "response": 0,
                          "explanation": {
                            "Model–View–Controller (MVC)": "Not matched: no mention of model-view separation.",
                            "Presentation–Abstraction–Controller (PAC)": "Not matched: no modular agents with presentation-abstraction-controller.",
                            "Database": "Not matched: no data storage or retrieval.",
                            "Microservice": "Not matched: no mention of independent services."
                          }
                        }
            
                        Example 2 (Match):
                        {
                          "ask": "We are building a system with many small, independent services that talk to each other over APIs.",
                          "patterns": [
                             "Microservice" , "Database"
                          ],
                          "found": true,
                          "response": 1,
                          "explanation": {
                            "Microservice": "Matched: Input describes 'independent services' communicating via 'APIs', which are core characteristics.",
                            "Client–Server": "Not matched: No specific mention of a client-server request/response model.",
                            "Database": "Not matched: no data storage or retrieval."
                          }
                        }
            
            """;
}
