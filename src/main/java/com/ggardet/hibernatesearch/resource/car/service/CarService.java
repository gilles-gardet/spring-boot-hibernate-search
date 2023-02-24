package com.ggardet.hibernatesearch.resource.car.service;

import com.ggardet.hibernatesearch.resource.car.model.Car;
import com.ggardet.hibernatesearch.resource.car.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public List<Car> searchCars() {
        return carRepository.searchBy("clio", 10, "alias");
    }
}
