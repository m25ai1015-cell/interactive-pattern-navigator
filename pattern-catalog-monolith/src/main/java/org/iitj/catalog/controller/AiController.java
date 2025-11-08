package org.iitj.catalog.controller;

import com.google.gson.Gson;
import org.iitj.catalog.dto.ChatRequest;
import org.iitj.catalog.dto.ChatResponse;
import org.iitj.catalog.dto.PatternAnalysis;
import org.iitj.catalog.model.Pattern;
import org.iitj.catalog.service.ChatService;
import org.iitj.catalog.service.PatternFileService;
import org.iitj.catalog.util.ChatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
//import com.google.gson.Gson;
//import com.google.gson.JsonObject;

@RestController
@RequestMapping("/api/v1/ai")
public class AiController {

    private final ChatService chatService;

    @Autowired
    private PatternFileService service;
    private final Gson gson = new Gson();


    public AiController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chat")
    public ResponseEntity<ChatResponse> chat(@Valid @RequestBody ChatRequest request) {
        String result = chatService.ask(request.getPrompt());
        return ResponseEntity.ok(new ChatResponse(result));
    }

    @PostMapping("/patterns")
    public ResponseEntity<List<Pattern>> findPattern(@Valid @RequestBody ChatRequest request) {
        String prompt = ChatUtil.FIND_PATTERN_PROMPT.replace("{INPUT}", request.getPrompt());
        String result = chatService.askPattern(prompt);
        try {
            PatternAnalysis p = gson.fromJson(result, PatternAnalysis.class);
            List<Pattern> patterns = new ArrayList<>();

            if(!p.explanation().isEmpty()) {
                for (String name : p.patterns()) {

                    Pattern pattern = service.findByKey(name);
                    if(pattern == null){
                        pattern= new Pattern();
                        pattern.setName(name);
                        String data = p.explanation().get(name);
                        pattern.setSummary(data);
                        pattern.setReasonMatched(data);
                        pattern.setComplexity("");
                        pattern.setDeployment("");
                    }

                    pattern.setReasonMatched(p.explanation().get(name));

                    patterns.add(pattern);
                }
            }
            return ResponseEntity.ok(patterns);
        }catch (Exception e){
            return ResponseEntity.ok(new ArrayList<>());
        }
    }

    @PostMapping("/queries")
    public ResponseEntity<ChatResponse> findPatterns(@Valid @RequestBody ChatRequest request) {
        String prompt = ChatUtil.FIND_PATTERN_PROMPT.replace("{INPUT}", request.getPrompt());
        String result = chatService.askPattern(prompt);
        return ResponseEntity.ok(new ChatResponse(result));
    }
}
