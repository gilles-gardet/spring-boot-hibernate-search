package com.ggardet.hibernatesearch.search.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface SearchRepository<T, ID> extends JpaRepository<T, ID> {
    List<T> searchBy(String text, int limit, String... fields);
    Optional<T> searchBy(String text, String... fields);
}
