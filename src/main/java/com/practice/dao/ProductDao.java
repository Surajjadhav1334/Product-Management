package com.practice.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.practice.entity.Product;

@Repository
public class ProductDao {

	@Autowired
	SessionFactory sessionFactory;

	public String addproduct(Product product) {
		Session Session = sessionFactory.openSession();

		Transaction Transaction = Session.beginTransaction();

		Session.save(product);

		Transaction.commit();

		return "Added";
	}

	public List<Product> getallproduct() {
		Session Session = sessionFactory.openSession();

		Transaction t = Session.beginTransaction();

		List<Product> list = Session.createQuery("from Product", Product.class).list();

//		t.commit();

		return list;

	}
	
	public Product getproductbyid(long id)
	{
		Session Session = sessionFactory.openSession();
		Transaction t = Session.beginTransaction();
		
		Product product = Session.get(Product.class, id);
		
		return product;
		
	}
	
	public String updateproduct(Product product)
	{
		Session Session = sessionFactory.openSession();
		Transaction t = Session.beginTransaction();
		
		Session.update(product);
		
		t.commit();
		
		return "updated";
		
	}
	
	public String deleteproduct(long id)
	{
		Session Session = sessionFactory.openSession();
		Transaction t = Session.beginTransaction();
		
		Product product = Session.get(Product.class, id);
		Session.delete(product);
		t.commit();
		return "deleted";
	}

}
