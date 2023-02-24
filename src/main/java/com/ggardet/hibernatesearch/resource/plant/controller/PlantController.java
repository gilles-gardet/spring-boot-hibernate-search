package com.ggardet.hibernatesearch.resource.plant.controller;

import com.ggardet.hibernatesearch.resource.plant.model.Plant;
import com.ggardet.hibernatesearch.resource.plant.service.PlantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/plants")
public class PlantController {
    private final PlantService plantService;

    @GetMapping
    public List<Plant> searchPlants() {
        return plantService.fetchPlants();
    }

    @GetMapping("/{alias}")
    public Optional<Plant> searchPlant(@PathVariable String alias) {
        return plantService.searchPlant(alias);
    }
}
