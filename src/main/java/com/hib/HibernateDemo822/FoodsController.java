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
		
		
		return mv;
	}
	
	// path variable is required to identify which food we want to edit
	@RequestMapping("/food/{id}/update")
	public ModelAndView showEditForm(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("food-form");
		mv.addObject("title","Update Food");
		mv.addObject("food", foodDao.findById(id).orElse(null));
		
		return mv;
		
	}
	
	@PostMapping("/food/{id}/update")
	public ModelAndView submitEditForm(Food food,@PathVariable("id") Long id) {
		food.setId(id);
		foodDao.save(food);
		return new ModelAndView("redirect:/food");
	}


}