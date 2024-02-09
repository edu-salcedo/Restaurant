package com.pollo.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pollo.demo.model.Category;
import com.pollo.demo.repository.CategoryRepository;
@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category save(Category category) {
		
		return null;
	}

	@Override
	public Category getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Category> get(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return  categoryRepository.findAll();
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
