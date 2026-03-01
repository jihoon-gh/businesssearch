package com.businesssearch.service;

import com.businesssearch.dto.SuggestionRequestParameter;
import com.businesssearch.util.Constants;
import com.businesssearch.util.NativeQueryBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.suggest.response.Suggest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SuggestionService {
    private final ElasticsearchOperations elasticsearchOperations;

    public List<String> fetchSuggestions(SuggestionRequestParameter parameter) {
        log.info("suggestion request: {}", parameter);

        NativeQuery suggestQuery = NativeQueryBuilder.toSuggestQuery(parameter);
        SearchHits<Object> searchHits = elasticsearchOperations.search(suggestQuery, Object.class, Constants.Index.SUGGESTION);

        return Optional.ofNullable(searchHits.getSuggest())
                .map(s -> s.getSuggestion(Constants.Suggestion.SUGGEST_NAME))
                .stream()
                .map(Suggest.Suggestion::getEntries)
                .flatMap(Collection::stream)
                .map(Suggest.Suggestion.Entry::getOptions)
                .flatMap(Collection::stream)
                .map(Suggest.Suggestion.Entry.Option::getText)
                .toList();

    }
}
