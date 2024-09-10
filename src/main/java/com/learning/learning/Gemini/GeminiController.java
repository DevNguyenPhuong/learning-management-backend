package com.learning.learning.Gemini;

import com.learning.learning.DTO.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gemini")
@RequiredArgsConstructor
public class GeminiController {
    private final GeminiService geminiService;
    @PostMapping
    public ApiResponse<String> createGemeniResponse(@RequestBody String prompt) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setData(geminiService.generateContent(prompt));
        return apiResponse;
    }
}
