package com.ig.jdbc.pms.dao;
import java.util.List;

import com.ig.jdbc.pms.model.Product;


public interface ProductDao {
	public void addProduct(Product product) throws Exception;
	public List<Product> listAllProducts() throws Exception;
	public static Product getProductById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
		
	

}
