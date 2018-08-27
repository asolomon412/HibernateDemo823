package com.hib.HibernateDemo822.dao;

import java.util.List;
import java.util.TreeSet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hib.HibernateDemo822.entity.Food;

// By extending JpaRepository we automatically get all the basic CRUD methods 
// We don't need to annotate this interface
// The JpaRepository interface requires two generics
// 1. The name of the class or entity that you are using
// 2. The type for the primary key as or the parent wrapper class for primitive types
public interface FoodRepository extends JpaRepository<Food, Long> {

	// We can add specific queries if needed
	// Use the naming conventions for Jpa (variable names should match
	// and be in camel case)
	List<Food> findByNameContaining(String keyword);

	List<Food> findByCategory(String category);
	
	List<Food> findByCategoryAndNameContaining(String category, String keyword);

	// Using this to show the diff using EntityManager and
	// a sorted TreeSet later
	// Set<String> findAllCategories();
	// SELECT DISTINCT category FROM Food
	@Query("select distinct category from Food")
	TreeSet<String> findDistinctCategory();

}
