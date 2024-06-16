package com.sunbeam.dao;

import com.sunbeam.entities.Product;

public interface ProductDao{
	String addProductDetails(Product product);
	Product getProductDetailsById(Long productIdLong);
}
