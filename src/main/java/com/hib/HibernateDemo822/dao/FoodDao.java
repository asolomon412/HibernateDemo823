package com.hib.HibernateDemo822.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.hib.HibernateDemo822.entity.Food;
/// ***** We are no longer using this!
@Repository
// DAOs must be transactional in order to use the EntityManager to write.
// This means that a transaction is created every time a method runs here.
@Transactional
public class FoodDao {
	
	// Use this annotation to have Spring inject the Hibernate entity manager
	@PersistenceContext
	private EntityManager em;

	
	public Food findById(Long id) {
		return em.find(Food.class, id);
	}
	
	public List<Food> findAll() {
		
		// The select clause is optional in HQL. If omitted, it's basically
		// like using SELECT *
		// When creating the query we must specify the type of results: Food.class
		return em.createQuery("FROM Food", Food.class).getResultList();
	}
	
}
