package com.ekta.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ekta.myapp.dao.RestaurantDAO;
import com.ekta.myapp.exception.ProjException;
import com.ekta.myapp.pojo.Person;
import com.ekta.myapp.pojo.Restaurant;
import com.ekta.myapp.pojo.RestaurantAdmin;

@Controller
//@RequestMapping("addRestaurant.htm")
public class RestaurantController {
	
	@RequestMapping(value="addRestaurant.htm",method = RequestMethod.POST)
	protected ModelAndView doSubmitAction(@ModelAttribute("restAdd") Restaurant rest,HttpServletRequest request) throws Exception {
//		validator.validate(user, result);
//		if (result.hasErrors()) {
//			return "addUserForm";
//		}
        ModelAndView mv=new ModelAndView();
		try {
			
			HttpSession session = request.getSession();
			System.out.print("test");
			RestaurantDAO restDAO = new RestaurantDAO();
			System.out.print("test1");
			RestaurantAdmin restAd = (RestaurantAdmin)session.getAttribute("person");
			Restaurant re = restDAO.getMyRestaurant(restAd);
			if(re == null){
			Restaurant restaurant=restDAO.create(rest.getRestName(),rest.getRestCity(),rest.getZipCode(),restAd);
			
			session.setAttribute("restSessionObj", restaurant);
			mv.addObject("myRestaurant", restaurant);
			mv.setViewName("successRestaurantAdded");
			return mv;
			}
			
			else{
				mv.setViewName("restAdminHome");
				System.out.println("You already have a restaurant added to the system");
				return mv;
			}
			// DAO.close();
		}
		catch (ProjException e) {
			System.out.println("Exception: " + e.getMessage());
			mv.addObject("myRestaurant", null);
			mv.setViewName("restAdminHome");
			return mv;
		}

		
	}
	
	@RequestMapping(value="viewRestaurant.htm")
	protected ModelAndView addRestaurantDetails(HttpServletRequest request){
		
		ModelAndView mv = new ModelAndView();
		
		try{
			HttpSession session = request.getSession();
			RestaurantDAO restDAO = new RestaurantDAO();
			RestaurantAdmin restAd = (RestaurantAdmin)session.getAttribute("person");
			
			Restaurant myRest=restDAO.getMyRestaurant(restAd);
			if(myRest != null)
			{mv.addObject("myRestaurant",myRest);
			mv.setViewName("successRestaurantAdded");
			return mv;
			}
			else{
				mv.setViewName("restAdminHome");
				System.out.println("Please add a restaurant to the system");
				return mv;
			}
		}
		catch(ProjException e){
			System.out.println("Exception: "+e.getMessage());
			mv.addObject("myRestaurant",null);
			mv.setViewName("restAdminHome");
			return mv;
		}
		
		
		
		
	}
	
	
	

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("restAdd") Person user) {

		return "successRestaurantAdded";
	}


}
