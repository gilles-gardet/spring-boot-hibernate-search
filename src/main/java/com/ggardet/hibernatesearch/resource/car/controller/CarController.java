package com.ggardet.hibernatesearch.resource.car.controller;

import com.ggardet.hibernatesearch.resource.car.model.Car;
import com.ggardet.hibernatesearch.resource.car.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @GetMapping("/search-all")
    public List<Car> searchCar() {
        return carService.searchCars();
    }
}
