package com.businesssearch.controller;

import com.businesssearch.dto.SuggestionRequestParameter;
import com.businesssearch.service.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BusinessSearchController {
    private final SuggestionService suggestionService;

    @GetMapping("/api/suggestions")
    public List<String> suggest(@ModelAttribute SuggestionRequestParameter parameter) {
        return suggestionService.fetchSuggestions(parameter);
    }
}
