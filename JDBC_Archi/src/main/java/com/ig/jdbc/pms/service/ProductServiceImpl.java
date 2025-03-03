package com.ig.jdbc.pms.service;

import java.util.ArrayList;
import java.util.List;

import com.ig.jdbc.pms.dao.ProductDao;
import com.ig.jdbc.pms.dao.ProductDaoImpl;
import com.ig.jdbc.pms.exception.ProductNotFoundException;
import com.ig.jdbc.pms.model.Product;

public class ProductServiceImpl  implements ProductService{
    ProductDao productDao;
	public void addProduct(Product product) throws Exception {
		productDao =new ProductDaoImpl();
		productDao.addProduct(product);
	}
	public List<Product> listAllProducts() throws Exception{
		ArrayList<Product> productList=new ArrayList<>();
		productDao =new ProductDaoImpl();
		
		return productDao.listAllProducts();
}
	@Override
	public Product getProductById(int id) throws ProductNotFoundException, Exception {
	    Product product = ProductDao.getProductById(id); // Use instance, not class name
	    if (product == null) {
	        throw new ProductNotFoundException("Product with ID " + id + " not found.");
	    }
	    return product;
	}

}