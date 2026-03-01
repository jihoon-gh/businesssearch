package com.businesssearch.util;

import co.elastic.clients.elasticsearch.core.search.*;

public class ElasticSearchUtil {
    public static Suggester buildCompletionSuggester(String suggestName, String field, String prefix, int limit) {
        SuggestFuzziness suggestFuzziness = SuggestFuzziness.of(builder -> builder.fuzziness(Constants.Fuzzy.LEVEL)
                .prefixLength(Constants.Fuzzy.PREFIX_LENGTH));

        CompletionSuggester completionSuggester = CompletionSuggester.of(builder -> builder.field(field)
                .size(limit)
                .fuzzy(suggestFuzziness)
                .skipDuplicates(true));

        FieldSuggester fieldSuggester = FieldSuggester.of(builder -> builder.prefix(prefix).completion(completionSuggester));
        return Suggester.of(builder -> builder.suggesters(suggestName, fieldSuggester));
    }
}
