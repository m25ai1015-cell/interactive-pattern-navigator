package org.iitj.catalog.controller;

import org.iitj.catalog.dto.ChatRequest;
import org.iitj.catalog.dto.ChatResponse;
import org.iitj.catalog.service.ChatService;
import org.iitj.catalog.util.ChatUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/ai")
public class AiController {

    private final ChatService chatService;

    public AiController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chat")
    public ResponseEntity<ChatResponse> chat(@Valid @RequestBody ChatRequest request) {
        String result = chatService.ask(request.getPrompt());
        return ResponseEntity.ok(new ChatResponse(result));
    }

    @PostMapping("/patterns")
    public ResponseEntity<ChatResponse> findPattern(@Valid @RequestBody ChatRequest request) {
        String prompt = ChatUtil.FIND_PATTERN_PROMPT.replace("{INPUT}", request.getPrompt());
        String result = chatService.askPattern(prompt);
        return ResponseEntity.ok(new ChatResponse(result));
    }
}
