package com.ekta.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ekta.myapp.dao.RestAdminDAO;
import com.ekta.myapp.dao.UserDAO;
import com.ekta.myapp.exception.ProjException;
import com.ekta.myapp.pojo.Person;
import com.ekta.myapp.pojo.RestaurantAdmin;
import com.ekta.myapp.pojo.User;

@Controller
@RequestMapping("registerAdmin.htm")
public class RegisterAdminController {
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("regAdmin") RestaurantAdmin restAdmin) throws Exception {
//		validator.validate(user, result);
//		if (result.hasErrors()) {
//			return "addUserForm";
//		}

		try {
			System.out.print("test");
			RestAdminDAO restDAO = new RestAdminDAO();
			System.out.print("test1");
			
			restDAO.create(restAdmin.getFirstName(),restAdmin.getLastName(),restAdmin.getCity(),restAdmin.getUsername(),restAdmin.getPassword(),restAdmin.getRoleType());
			
			// DAO.close();
		} catch (ProjException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "home";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("regUser") RestaurantAdmin restAdmin) {

		return "home";
	}

}
