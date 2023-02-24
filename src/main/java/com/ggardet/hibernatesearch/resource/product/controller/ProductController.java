package com.ggardet.hibernatesearch.resource.product.controller;

import com.ggardet.hibernatesearch.resource.product.model.Product;
import com.ggardet.hibernatesearch.resource.product.service.ProductService;
import com.ggardet.hibernatesearch.search.model.SearchRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/search-all")
    public List<?> searchProducts(SearchRequestDTO searchRequestDTO) {
        var text = searchRequestDTO.getText();
        var fields = searchRequestDTO.getFields();
        var limit = searchRequestDTO.getLimit();
//        return productService.searchProducts(text, fields, limit);
        return productService.searchProducts(text);
    }

    @GetMapping("/search-single")
    public Optional<Product> searchProduct(SearchRequestDTO searchRequestDTO) {
        var text = searchRequestDTO.getText();
        return productService.searchProduct(text);
    }
}
