package com.ig.jdbc.pms.service;

import java.util.List;

import com.ig.jdbc.pms.exception.ProductNotFoundException;
import com.ig.jdbc.pms.model.Product;

public interface ProductService {
	
	public void addProduct(Product product) throws Exception;
	public List<Product> listAllProducts() throws Exception;
	Product getProductById(int id) throws ProductNotFoundException, Exception;
}