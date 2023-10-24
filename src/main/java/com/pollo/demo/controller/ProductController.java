package com.pollo.demo.controller;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pollo.demo.model.Product;
import com.pollo.demo.service.ProductService;

import ch.qos.logback.classic.Logger;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService productService;
	
	private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ProductController.class);
	
	
//     methods
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("products",productService.getAll());
		return "product/index";
	}
	
	@GetMapping("/create")
	public String create() {
		
		return "product/create";
		
	}	
	
	@PostMapping("/save")
	public String save(Product product) {
		productService.save(product);
		return "redirect:/product";
   	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable Integer id,Model model) {
	   Product product= new Product();
	   product=productService.getById(id);
	   model.addAttribute("product",product);
//		productService.delete(product);
	   LOGGER.info("ESTE ES EL PRODUCTO {}",product);
		return "product/edit";
	}

	
	
	@DeleteMapping("delete/{product}")
	public String delete(Product product) {
	
		productService.delete(product);
		return "mesaje";
	}

}
