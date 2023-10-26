package com.pollo.demo.controller;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pollo.demo.model.Product;
import com.pollo.demo.service.ProductService;
import com.pollo.demo.service.UploadFileImgService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UploadFileImgService upload;
	
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
	public String save(Product product,@RequestParam("img") MultipartFile file) throws IOException
	{
		
		if(product.getId()==null) {
			
			String ImgName = upload.SaveImg(file);
		}
		productService.save(product);
		return "redirect:/product";
   	} 
	
	
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable Integer id,Model model) {
		
	   Product product= new Product();
	   product=productService.getById(id);
	   
	   model.addAttribute("product",product);
		return "product/edit";
	}
	
	@PostMapping("/update")
	public String update(Product product,@RequestParam("img") MultipartFile file) throws IOException {
		  
//		 si la imagen no esta vacia 
		if(file.isEmpty()) {
				Product pro= new Product();
				pro=productService.get(product.getId()).get();
	           product.setImgUrl(pro.getImg());	
			}else {
				String Imgname=upload.SaveImg(file);
				product.setImgUrl(Imgname);
			}
		productService.update(product);
		return "redirect:/product";
   	}

	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable  Integer id) {
	
		Product pro= new Product();
		pro=productService.get(id).get();
		
//		IScope laIScope imagen a eliminar no es el default 
		if(!pro.getImg().equals("default.jpg")) {
			upload.deleteImg(pro.getImg());
		}
		
		productService.delete(id);
		return "redirect:/product";
	}

}
