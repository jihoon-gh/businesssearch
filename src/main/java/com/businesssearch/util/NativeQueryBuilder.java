package com.businesssearch.util;

import com.businesssearch.dto.SuggestionRequestParameter;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;

import static com.businesssearch.util.ElasticSearchUtil.buildCompletionSuggester;

public class NativeQueryBuilder {

    public static NativeQuery toSuggestQuery(SuggestionRequestParameter parameter) {
        var suggester = buildCompletionSuggester(
                Constants.Suggestion.SUGGEST_NAME, Constants.Suggestion.SEARCH_TERM, parameter.prefix(), parameter.limit()
        );

        return NativeQuery.builder()
                .withSuggester(suggester)
                .withMaxResults(0)
                .withSourceFilter(FetchSourceFilter.of(b -> b.withExcludes("*")))
                .build();
    }
}
