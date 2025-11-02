package org.iitj.catalog.service;

import org.iitj.catalog.dto.PatternAnalysis;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String ask(String prompt) {
        return chatClient
                .prompt()
                .user(prompt)
                .call()
                .content();   // now returns the generated text directly
    }

    public String askPattern(String prompt) {
        return chatClient
                .prompt()
                .user(prompt)
                .call()
                .content();
                //.entity(PatternAnalysis.class);
    }
}
