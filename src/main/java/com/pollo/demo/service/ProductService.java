package com.pollo.demo.service;

import java.util.List;
import java.util.Optional;

import com.pollo.demo.model.Product;

public interface ProductService {
   public Product save( Product produt);
   public Product getById(Integer id);
   public Optional<Product> get(Integer id);
   public List<Product> getAll();
   public void update(Product producto);
   public void delete(Integer id);
}
