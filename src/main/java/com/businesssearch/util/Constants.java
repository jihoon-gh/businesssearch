package com.businesssearch.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
    public static class Index {
        public static final IndexCoordinates SUGGESTION = IndexCoordinates.of("suggestions");
        public static final IndexCoordinates BUSINESS = IndexCoordinates.of("business");
    }

    public static class Suggestion {
        public static final String SEARCH_TERM = "search_term";
        public static final String SUGGEST_NAME = "search-term-suggest";
    }

    public static class Fuzzy {
        public static final String LEVEL = "1";
        public static final Integer PREFIX_LENGTH = 2;
    }
}
