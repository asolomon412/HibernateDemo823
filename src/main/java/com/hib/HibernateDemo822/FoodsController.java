package com.hib.HibernateDemo822;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hib.HibernateDemo822.dao.FoodDao;

@Controller
public class FoodsController {
	
	@Autowired
	FoodDao foodDao;
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}


}