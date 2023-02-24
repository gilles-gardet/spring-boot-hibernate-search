package com.ggardet.hibernatesearch.resource.product.repository;

import com.ggardet.hibernatesearch.resource.product.model.Product;
import com.ggardet.hibernatesearch.search.repository.SearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends SearchRepository<Product, Long> {
    Optional<Product> findByAlias(String alias);
}
