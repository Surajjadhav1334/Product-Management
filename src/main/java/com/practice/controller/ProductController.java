package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.Product;
import com.practice.service.ProductService;

@RestController
@RequestMapping("api/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/addproduct")
	public String addproduct(@RequestBody Product product) {
		return productService.addproduct(product);
	}

	@GetMapping("/allproduct")
	public List<Product> getallproduct() {
		return productService.getallproduct();
	}
	
	@GetMapping("/{id}")
	public Product getproductbyid(@PathVariable("id") long id)
	{
		return productService.getproductbyid(id);
		
	}
	
	@PutMapping("/update")
	public String updateproduct(@RequestBody Product product)
	{
		return productService.updateproduct(product);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteproduct(@PathVariable("id") long id)
	{
		return productService.deleteproduct(id);
	}
	

}
