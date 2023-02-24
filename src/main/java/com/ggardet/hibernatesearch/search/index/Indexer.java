package com.ggardet.hibernatesearch.search.index;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Component
public class Indexer {
    private static final int THREAD_NUMBER = 4;
    private final EntityManager entityManager;

    @SneakyThrows
    public void indexPersistedData(List<Class<?>> indexClasses) {
            SearchSession searchSession = Search.session(entityManager);
            searchSession
                    .schemaManager(indexClasses)
                    .dropAndCreate();
            searchSession
                    .massIndexer()
                    .threadsToLoadObjects(THREAD_NUMBER)
                    .startAndWait();
    }
}
