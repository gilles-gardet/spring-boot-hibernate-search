package com.ggardet.hibernatesearch.resource.bicycle.service;

import com.ggardet.hibernatesearch.resource.bicycle.model.Bicycle;
import com.ggardet.hibernatesearch.resource.bicycle.repository.BicycleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BicycleService {
    private final BicycleRepository bicycleRepository;

    public Optional<Bicycle> searchBicycle(String text) {
        return bicycleRepository.searchBy(text, "alias");
    }
}
