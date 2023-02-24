package com.ggardet.hibernatesearch.resource.bicycle.controller;

import com.ggardet.hibernatesearch.resource.bicycle.model.Bicycle;
import com.ggardet.hibernatesearch.resource.bicycle.service.BicycleService;
import com.ggardet.hibernatesearch.search.model.SearchRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/bicycles")
public class BicycleController {
    private final BicycleService bicycleService;

    @GetMapping("/search")
    public Optional<Bicycle> searchBicycle(SearchRequestDTO searchRequestDTO) {
        var text = searchRequestDTO.getText();
        return bicycleService.searchBicycle(text);
    }
}
