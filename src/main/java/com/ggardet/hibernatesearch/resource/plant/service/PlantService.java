package com.ggardet.hibernatesearch.resource.plant.service;

import com.ggardet.hibernatesearch.resource.plant.model.Plant;
import com.ggardet.hibernatesearch.resource.plant.repository.PlantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlantService {
    private final PlantRepository plantRepository;

    public List<Plant> fetchPlants() {
        return plantRepository.findAll();
    }

    public Optional<Plant> searchPlant(String alias) {
        return plantRepository.findByAlias(alias);
    }
}
