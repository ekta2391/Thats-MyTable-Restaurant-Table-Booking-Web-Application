package com.ekta.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ekta.myapp.dao.UserDAO;
import com.ekta.myapp.exception.ProjException;
import com.ekta.myapp.pojo.Person;
import com.ekta.myapp.pojo.User;


@Controller
@RequestMapping("registerUser.htm")
public class RegisterUserController {
//	@Autowired
//	@Qualifier("userValidator")
//	UserValidator validator;
//
//	@InitBinder
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(validator);
//	}

	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("regUser") User user) throws Exception {
//		validator.validate(user, result);
//		if (result.hasErrors()) {
//			return "addUserForm";
//		}

		try {
			System.out.print("test");
			UserDAO userDAO = new UserDAO();
			System.out.print("test1");
			
			userDAO.create(user.getFirstName(),user.getLastName(),user.getCity(),user.getUsername(),user.getPassword(),user.getRoleType());
			
			// DAO.close();
		} catch (ProjException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "home";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("regUser") Person user) {

		return "home";
	}

}
