package com.ggardet.hibernatesearch.resource.car.repository;

import com.ggardet.hibernatesearch.resource.car.model.Car;
import com.ggardet.hibernatesearch.search.repository.SearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends SearchRepository<Car, Long> {
}
