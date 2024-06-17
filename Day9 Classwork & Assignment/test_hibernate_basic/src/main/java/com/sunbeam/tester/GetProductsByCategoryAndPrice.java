package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDAOImpl;
import com.sunbeam.dao.ProductDao;
import com.sunbeam.entities.Category;

public class GetProductsByCategoryAndPrice {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc=new Scanner(System.in);
				) {
			// create dao instance
			ProductDao dao = new ProductDAOImpl();
			System.out.println("Enter category n start end price");
			dao.getProductDetailsByCategoryAndPrice(Category.valueOf(sc.next().toUpperCase()),
				sc.nextDouble(),sc.nextDouble())
			.forEach(System.out::println);//u -> System.out.println(u)
		} // JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
