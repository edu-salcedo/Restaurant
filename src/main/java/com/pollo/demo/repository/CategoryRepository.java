package com.pollo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pollo.demo.model.Category;
@Repository
public interface CategoryRepository  extends JpaRepository<Category, Integer>{

}
