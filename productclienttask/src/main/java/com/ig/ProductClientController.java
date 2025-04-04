package com.ig;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.ig.model.Product;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ProductClientController {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String productServiceUrl = "http://localhost:8081/product";

    @GetMapping("/{id}")
    public Product fetchProduct(@PathVariable int id) {
        return restTemplate.getForObject(productServiceUrl + "/" + id, Product.class);
    }

    @GetMapping("/recommendations")
    public List<Product> fetchRecommendations() {
        return restTemplate.getForObject(productServiceUrl + "/recommendations", List.class);
    }
}