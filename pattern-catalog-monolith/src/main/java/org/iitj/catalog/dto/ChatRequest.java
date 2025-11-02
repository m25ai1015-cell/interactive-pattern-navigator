package org.iitj.catalog.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChatRequest {
    @NotBlank
    private String prompt;

}
