package com.ekta.myapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ekta.myapp.dao.RestaurantDAO;
import com.ekta.myapp.exception.ProjException;
import com.ekta.myapp.pojo.Person;
import com.ekta.myapp.pojo.Restaurant;

@Controller
@RequestMapping("/restaurantSearchResult.htm")
public class RestaurantSearchResultController {
	
	@RequestMapping(method = RequestMethod.POST)
	protected ModelAndView doSubmitAction(@ModelAttribute("searchResults") Restaurant restaurant) throws Exception {
//		validator.validate(user, result);
//		if (result.hasErrors()) {
//			return "addUserForm";
//		}
ModelAndView mv = new ModelAndView();
		try {
			System.out.print("test");
			RestaurantDAO restDAO = new RestaurantDAO();
			System.out.print("test1");
			
			List<Restaurant> restList=restDAO.get(restaurant.getRestCity());
			
			
			
	
		
			
			
			// DAO.close();
			if(restList.size()==0){
				mv.setViewName("userHome");
				return mv;
				
			}
			
			
			else{	
			mv.addObject("restList",restList);
			mv.setViewName("searchResult");
			return mv;
		}
		
		
		
		} catch (ProjException e) {
			System.out.println("Exception: " + e.getMessage());
			
			mv.addObject("searchSuccess",null);
			mv.setViewName("userHome");
			return mv;
		}
   
     
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("searchResult") Person person) {

		return "userHome";
	}

}
