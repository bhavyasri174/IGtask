package com.ig;

import org.springframework.web.bind.annotation.*;

import com.ig.model.Product;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    private List<Product> productList = List.of(
        new Product(1, "Laptop", 80000),
        new Product(2, "Mouse", 500),
        new Product(3, "Keyboard", 900),
        new Product(4, "Monitor", 7000)
    );

    private List<Product> cartList = new ArrayList<>();


	@GetMapping("{id}")
	public String AddtoCart(@PathVariable int id) {
		Product product = productList.stream().filter(p->p.getId()==id).findFirst().orElse(null);
		if(product != null && product.getPrice()<10000) {
			cartList.add(product);
			return "Added to Cart Succesfully:"+product.getName();
		}
		return "Product not added to Cart(Budget Exceeded)";
	}
	
	@GetMapping("/recommendations")
	public List<Product> Reccomendation(){
		if(cartList.isEmpty()) {
			return List.of();
		}
		double maxValue = cartList.stream().mapToDouble(Product::getPrice).max().orElse(0);
		return productList.stream().filter(p->p.getPrice()<=maxValue).toList();
	}

}