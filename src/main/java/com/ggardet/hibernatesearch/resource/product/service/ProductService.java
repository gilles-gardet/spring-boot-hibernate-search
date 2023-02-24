package com.ggardet.hibernatesearch.resource.product.service;

import com.ggardet.hibernatesearch.resource.bicycle.model.Bicycle;
import com.ggardet.hibernatesearch.resource.car.model.Car;
import com.ggardet.hibernatesearch.resource.plant.model.Plant;
import com.ggardet.hibernatesearch.resource.product.model.Product;
import com.ggardet.hibernatesearch.resource.product.repository.ProductRepository;
import com.ggardet.hibernatesearch.search.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private static final List<String> SEARCHABLE_FIELDS = List.of("alias");
    private final ProductRepository ProductRepository;
    private final SearchService searchService;

    public List<Product> searchProducts(String text, List<String> fields, int limit) {
        List<String> fieldsToSearchBy = fields.isEmpty() ? SEARCHABLE_FIELDS : fields;
        boolean containsInvalidField = fieldsToSearchBy.stream().anyMatch(f -> !SEARCHABLE_FIELDS.contains(f));
        if (containsInvalidField) {
            throw new IllegalArgumentException();
        }
        return ProductRepository.searchBy(text, limit, fieldsToSearchBy.toArray(new String[0]));
    }

    public List<?> searchProducts(String text) {
        List<Class<?>> classes = List.of(Car.class, Bicycle.class, Plant.class);
        return searchService.searchMultipleMatchBy(classes, text, 20, "alias");
    }

    public Optional<Product> searchProduct(String text) {
        return ProductRepository.searchBy(text, SEARCHABLE_FIELDS.toArray(new String[0]));
        // FIX: this won't work if the alias exists in multiple tables
//        return ProductRepository.findByAlias(text);
    }
}
