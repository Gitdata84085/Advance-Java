package com.sunbeam.dao;

import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

import com.sunbeam.entities.Category;
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

	@Override
	public List<Product> getProductDetailsByCategoryAndPrice(Category category, Double priceStart, Double priceEnd) {
		String jpql = "select p from Product p where p.category=:cat and p.price between :start and :end";
		List<Product> products = null;
		
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			products = session.createQuery(jpql, Product.class)
					.setParameter("cat",category)
					.setParameter("start",priceStart)
					.setParameter("end",priceEnd)
					.getResultList();
			tx.commit();
		}catch(RuntimeException e) {
			if (tx!=null)
				tx.rollback();
			throw e;
		}
		return products;
	}

	@Override
	public String applyDiscount(Category category, Double discount) {
		String mesg = "applying discount failed...!";
		String jqpl = "update Product p set p.price = p.price - :discount where category=:cat";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			int products = session.createQuery(jqpl)
					.setParameter("discount", discount)
					.setParameter("cat",category)
					.executeUpdate();
			tx.commit();
			mesg = "Applied discount to products -" + products;
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String purchaseProduct(Long id, int quantity) {
		String mesg = "Purchase Unsuccessfull";
		Product product = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			product = session.get(Product.class, id);
			if(product.getQuantity()> quantity)
				mesg = "Purchase successfull";
			product.setQuantity(product.getQuantity()-quantity);
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
		}
		return mesg;
	}
	
	

}
