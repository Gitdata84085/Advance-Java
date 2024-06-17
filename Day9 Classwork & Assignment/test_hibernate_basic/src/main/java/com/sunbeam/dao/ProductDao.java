package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

public interface ProductDao{
	String addProductDetails(Product product);
	Product getProductDetailsById(Long productIdLong);
	List<Product> getProductDetailsByCategoryAndPrice(Category category, Double priceStart, Double priceEnd);
	String applyDiscount(Category category, Double discount);
	String purchaseProduct(Long id, int quantity);
	
}
