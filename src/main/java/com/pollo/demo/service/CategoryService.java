package com.pollo.demo.service;

import java.util.List;
import java.util.Optional;

import com.pollo.demo.model.Category;
public interface CategoryService {
	   public Category save( Category  category);
	   public Category  getById(Integer id);
	   public Optional<Category > get(Integer id);
	   public List<Category > getAll();
	   public void update(Category  category);
	   public void delete(Integer id);

}
