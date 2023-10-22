package com.pollo.demo.controller;



import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pollo.demo.model.Product;
import com.pollo.demo.service.ProductService;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	private final Logger LOGGER= (Logger) LoggerFactory.getLogger(ProductController.class);
	@Autowired
	ProductService productService;
	
	@GetMapping("")
	public String index() {
		return "product/index";
	}
	
//	@GetMapping("/index")
//	public List<Product> getProducts(){
//		
//		return productService.getAll();
//	}
	
	@GetMapping("/index")
	public Product getById(Integer id){		
		return productService.getById(id);
	}
	
	@GetMapping("/create")
	public String create() {
		return "product/create";
	}	
	
	@PostMapping("/save")
	public String save(Product product) {
		LOGGER.info("ESTE ES EL PRODUCTO {}",product);
		productService.save(product);
		return "redirect:/product";
   	}
	@DeleteMapping("/{product}")
	public String delete(Product product) {
	
		productService.delete(product);
		return "mesaje";
	}

}
