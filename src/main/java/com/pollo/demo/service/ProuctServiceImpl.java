package com.pollo.demo.service;
import java.util.List;
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

		return productRepository.findById(id);
	}

	@Override
	public void update(Product product) {
	 productRepository.save(product);

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
        productRepository.deleteById(id);
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product getById(Integer id) {
		// TODO Auto-generated method stub
		return productRepository.getReferenceById(id);
	}

}
