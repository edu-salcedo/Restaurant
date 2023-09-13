package com.pollo.demo.service;

import java.util.Optional;

import com.pollo.demo.model.Product;

public interface ProductService {
   public Product save( Product produt);
   public Optional<Product> get(Integer id);
   public void update(Product producto);
   public void delete(Product product);
}
