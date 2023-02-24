package com.ggardet.hibernatesearch.resource.plant.repository;

import com.ggardet.hibernatesearch.resource.plant.model.Plant;
import com.ggardet.hibernatesearch.search.repository.SearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlantRepository extends SearchRepository<Plant, Long> {
    Optional<Plant> findByAlias(String alias);
}
