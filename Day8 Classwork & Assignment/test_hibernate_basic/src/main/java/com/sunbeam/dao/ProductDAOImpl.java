package com.sunbeam.dao;

import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;

import com.sunbeam.entities.Product;

public class ProductDAOImpl implements ProductDao {

	@Override
	public String addProductDetails(Product product) {

		String mesg = "The Product is not added!";

		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			Serializable productId = session.save(product);
			tx.commit();
			mesg = "product details added successfully, with ID" + productId;
		} catch (RuntimeException e) {

			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public Product getProductDetailsById(Long productIdLong) {
		Product product = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			product = session.get(Product.class, productIdLong);
			tx.commit();
		} catch (RuntimeException e) {

			if (tx != null)
				tx.rollback();
			throw e;
		}
		return product;
	}

}
