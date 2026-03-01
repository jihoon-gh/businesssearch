package com.businesssearch.dto;

import com.businesssearch.exception.BadRequestException;
import org.springframework.util.StringUtils;

import java.util.Objects;

public record SuggestionRequestParameter(String prefix, Integer limit) {

    public SuggestionRequestParameter {
        if(!StringUtils.hasText(prefix)) {
            throw new BadRequestException("prefix cannot be empty");
        }
        limit = Objects.requireNonNullElse(limit, 10);
    }
}
