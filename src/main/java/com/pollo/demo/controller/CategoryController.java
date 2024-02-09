package com.pollo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pollo.demo.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService catService;
	
//  methods
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("categories",catService.getAll());
		return "category/index";
	}
}
