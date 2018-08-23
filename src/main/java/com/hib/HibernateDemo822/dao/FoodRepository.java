package com.hib.HibernateDemo822.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hib.HibernateDemo822.entity.Food;

// By extending JpaRepository we automatically get all the basic CRUD methods 
// We don't need to annotate this interface
public interface FoodRepository extends JpaRepository<Food, Long> {
	
	// We can add specific queries if needed
	// Use the naming conventions for Jpa (variable names should match
	// and be in camel case)
	List<Food> findByNameContaining(String keyword);
	
	List<Food> findByCategory(String category);
	
	// Using this to show the diff using EntityManager and 
	// a sorted TreeSet later
	//Set<String> findAllCategories();

}
