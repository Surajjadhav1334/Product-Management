package com.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.practice.dao.ProductDao;
import com.practice.entity.Product;

@Service
public class ProductService {
	
	@Autowired
	ProductDao productDao;
	
	public String addproduct(Product product)
	{
		return productDao.addproduct(product);
	}
	
	public List<Product> getallproduct()
	{
		return productDao.getallproduct();
		
	}
	public Product getproductbyid(long id)
	{
		return productDao.getproductbyid(id);
		
	}
	
	public String updateproduct(Product product)
	{
		return productDao.updateproduct(product);
	}
	
	public String deleteproduct(long id)
	{
		return productDao.deleteproduct(id);
	}

}
