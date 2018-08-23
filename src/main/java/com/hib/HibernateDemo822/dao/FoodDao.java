package com.hib.HibernateDemo822.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.hib.HibernateDemo822.entity.Food;

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
	
}
