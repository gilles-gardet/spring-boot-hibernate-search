package com.ggardet.hibernatesearch.resource.bicycle.repository;

import com.ggardet.hibernatesearch.resource.bicycle.model.Bicycle;
import com.ggardet.hibernatesearch.search.repository.SearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BicycleRepository extends SearchRepository<Bicycle, Long> {
}
