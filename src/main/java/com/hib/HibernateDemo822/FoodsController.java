package com.hib.HibernateDemo822;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hib.HibernateDemo822.dao.FoodRepository;
import com.hib.HibernateDemo822.entity.Food;

@Controller
public class FoodsController {
	
	@Autowired
	FoodRepository foodDao;
	
	@RequestMapping("/")
	public ModelAndView home() {
		
		return new ModelAndView("index");
	}
	
	@RequestMapping("/food")
	public ModelAndView listFood() {
		ModelAndView mv = new ModelAndView("list-food");
		
		mv.addObject("foods", foodDao.findAll());
		System.out.println(foodDao.findByCategoryAndNameContaining("Fruit","e"));
		System.out.println(foodDao.findDistinctCategory());
		return mv;
	}
	
	// path variable is required to identify which food we want to edit
	@RequestMapping("/food/{id}/update")
	public ModelAndView showEditForm(@PathVariable("id") Food id) {
		ModelAndView mv = new ModelAndView("food-form");
		mv.addObject("title","Update Food");
		// foodDao.findById(id).orElse(null) -- old param
		// we can remove this method because the JpaRepository is 
		// equipped with the ability to find by id when assigning the
		// paths variable id to the type of Object : Food in this case
		// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
		mv.addObject("food", id);
		
		return mv;
		
	}
	
	@PostMapping("/food/{id}/update")
	public ModelAndView submitEditForm(Food food) {
		// made more modifications here
		// using the same url from the form page, but EL and Jpa are smart enough 
		// to know that the value coming in is missing an id
		// so it routes it to this method and saves the id as null 
		// along with the other values
		//food.setId(id); // here we need the food object to save the new data from 
		// the updates in the form
		//,@PathVariable("id") Long id
		foodDao.save(food);
		return new ModelAndView("redirect:/food");
	}

	@RequestMapping("/food/create")
	public ModelAndView showCreateForm() {
		// If there is only one model value to add, use this one-line shortcut. Equivalent to
		// ModelAndView mav = new ModelAndView("food-form");
		// mav.addObject("title", "Add a Food");
		
		return new ModelAndView("food-form", "title", "Add a Food");
	}
	
	@PostMapping(value="/food/create")
	public ModelAndView submitCreateForm(Food food) {
		foodDao.save(food);
		return new ModelAndView("redirect:/food");
	}
	
	@RequestMapping("/food/{id}/delete")
	public ModelAndView delete(@PathVariable("id") Long id) {
		foodDao.deleteById(id);
		return new ModelAndView("redirect:/food");
	}

}