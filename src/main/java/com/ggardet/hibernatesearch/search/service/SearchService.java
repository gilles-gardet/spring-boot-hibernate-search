package com.ggardet.hibernatesearch.search.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Manager used to offers default methods to search through the {@link Entity}s indexes managed by the Hibernate
 * Search Engine.
 *
 * @since 2022.3.0
 */
@Component
@Transactional
@RequiredArgsConstructor
public class SearchService {
    private final EntityManager entityManager;

    /**
     * Search through the indexed {@link Entity}s into the specified fields with the specified searched term.
     * A single result should be returned.
     *
     * @param classes the type of the {@link Entity}s to be searched on
     * @param text the exact match of the searched term (could be an identifier, a name...)
     * @param fields the fields on which the search should be performed
     * @return a single result wrapped as an {@link Optional}
     * @since 2022.3.0
     */
    public Optional<?> searchSingleMatchBy(
            Collection<? extends Class<?>> classes,
            String text,
            String... fields
    ) {
        SearchSession searchSession = Search.session(entityManager);
        return searchSession
                .search(classes)
                .where(predicate -> predicate.match().fields(fields).matching(text))
                .fetchSingleHit();
    }

    /**
     * Search through the indexed {@link Entity}s into the specified fields with the specified searched term.
     * Potentially multiple results could be returned.
     *
     * @param classes the type of the {@link Entity}s to be searched on
     * @param text    the exact match of the searched term (could be an identifier, a name...)
     * @param fields  the fields on which the search should be performed
     * @return a list of results
     * @since 2022.3.0
     */
    public List<?> searchMultipleMatchBy(
            Collection<? extends Class<?>> classes,
            String text,
            int limit,
            String... fields
    ) {
        SearchSession searchSession = Search.session(entityManager);
        var result = searchSession
                .search(classes)
                .where(predicate -> predicate.match().fields(fields).matching(text))
                .fetch(limit);
        return result.hits();
    }
}
