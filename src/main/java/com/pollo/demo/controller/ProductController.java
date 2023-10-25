package com.pollo.demo.controller;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		LOGGER.info("PRODUCTO CREADO {}",product);
		return "redirect:/product";
   	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable Integer id,Model model) {
	   Product product= new Product();
	   product=productService.getById(id);
	   model.addAttribute("product",product);
	   LOGGER.info(" TRAER EL PRODUCTO {}",product);
		return "product/edit";
	}
	
	@PostMapping("/update")
	public String update(Product product) {
		
		LOGGER.info("PRODUCTO ANTES DE ACTUALIZAR {}",product);
		productService.update(product);
		LOGGER.info("PRODUCTO ACTUALIZADO {}",product);
		return "redirect:/product";
   	}

	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable  Integer id) {
	
		productService.delete(id);
		return "redirect:/product";
	}

}
