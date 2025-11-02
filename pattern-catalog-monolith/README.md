## what it does? 
It interacts with LLMs and finds appropriate matching patterns

## implementation
1. Ollama local
2. Gemini Pro

For gemini pro tweak the configuretaion
```yaml
spring:
  ai:
    google:
      gemini:
        api-key: Gemini API Key from Google AI Studio
        model: gemini-1.5-pro-latest
        default-options:
          temperature: 0.7
          safety-settings-threshold: BLOCK_NONE
```

## Testing with Ollama
<img width="2772" height="1958" alt="image" src="https://github.com/user-attachments/assets/4e851de4-38a3-4faf-b459-5c96be838f69" />

## Gemini works better
```curl
curl -X POST http://localhost:8080/api/v1/ai/patterns \
  -H "Content-Type: application/json" \
  -d '{"prompt": "I want to scale serivces and views can be different"}'
```
<img width="1308" height="183" alt="image" src="https://github.com/user-attachments/assets/93afc8f7-af24-47d5-aec2-ab6d6a65e239" />
response 

```json
"patterns": ["Microservice", "Client–Server"],     "found": true,     "response": 2,    "explanation": {n       "Microservice": "Describes an application composed of small, independently deployable services communicating via APIs, which facilitates scaling.",    "Client–Server": "Since the user wants to scale services, this suggests a centralized server providing resources to multiple clients."     }   }"}
```
