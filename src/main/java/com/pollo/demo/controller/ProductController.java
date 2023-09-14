package com.pollo.demo.controller;

import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pollo.demo.model.Product;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	private final Logger logger =(Logger) LoggerFactory.getLogger(ProductController.class);
	
	@GetMapping("")
	public String index() {
		return "product/index";
	}
	
	@GetMapping("/create")
	public String create() {
		return "product/create";
	}	
	
	@GetMapping("/save")
	public String save(Product product) {
		
		logger.info("producto{}",product);
		
		return "redirect:/product";
	}

}
