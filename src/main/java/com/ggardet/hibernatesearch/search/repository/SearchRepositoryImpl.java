package com.ggardet.hibernatesearch.search.repository;

import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Transactional
public class SearchRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements SearchRepository<T, ID> {
    private final EntityManager entityManager;

    public SearchRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }

    public SearchRepositoryImpl(
            JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public List<T> searchBy(String text, int limit, String... fields) {
        SearchResult<T> result = getSearchResult(text, limit, fields);
        return result.hits();
    }

    private SearchResult<T> getSearchResult(String text, int limit, String[] fields) {
        SearchSession searchSession = Search.session(entityManager);
        return searchSession
                .search(getDomainClass())
                .where(f -> f.match().fields(fields).matching(text).fuzzy(2))
                .fetch(limit);
    }

    @Override
    public Optional<T> searchBy(String text, String... fields) {
        return getSearchResult(text, fields);
    }

    private Optional<T> getSearchResult(String text, String[] fields) {
        SearchSession searchSession = Search.session(entityManager);
        return searchSession
                .search(getDomainClass())
                .where(f -> f.match().fields(fields).matching(text))
                .fetchSingleHit();
    }
}
