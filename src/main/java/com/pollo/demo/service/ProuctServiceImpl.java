package com.pollo.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pollo.demo.model.Product;
import com.pollo.demo.repository.ProductRepository;

@Service
public class ProuctServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Override
	public Product save(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public Optional<Product> get(Integer id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	@Override
	public void update(Product product) {
		productRepository.save(product);
		
	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		
	}

}
