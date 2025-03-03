package com.ig.jdbc.pms.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ig.jdbc.pms.model.Product;
import com.ig.jdbc.pms.util.DbUtil;

public class ProductDaoImpl implements ProductDao{

	public void addProduct(Product product) throws Exception{
	  Connection con=DbUtil.getConnection();
	  PreparedStatement pst=con.prepareStatement("insert into product values (?,?)");
	  pst.setInt(1,product.getId());
	  pst.setString(2, product.getName());
	  pst.execute();
		
	}
	
	public List<Product> listAllProducts() throws Exception{
		ArrayList<Product> productList=new ArrayList<>();
		  Connection con=DbUtil.getConnection();
			Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from product");
		while(rs.next()) {
			Product product=new Product();
			product.setId(rs.getInt(1));
			product.setName(rs.getString(2));
			productList.add(product);
		}
		return productList;
	}

	public Product getProductById(int id) throws Exception {
	    Connection con = DbUtil.getConnection();
	    String sql = "SELECT * FROM products WHERE id = ?";
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setInt(1, id);
	    ResultSet rs = ps.executeQuery();

	    if (rs.next()) { // If data exists
	        Product product = new Product();
	        product.setId(rs.getInt("id"));
	        product.setName(rs.getString("name"));
	        con.close();
	        return product;
	    } else {
	        con.close();
	        return null; // Ensure null is returned if no product found
	    }
	}

}
