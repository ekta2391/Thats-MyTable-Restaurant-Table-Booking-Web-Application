package com.ekta.myapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ekta.myapp.dao.RestaurantDAO;

import com.ekta.myapp.dao.TableDAO;
import com.ekta.myapp.exception.ProjException;
import com.ekta.myapp.pojo.Person;
import com.ekta.myapp.pojo.Restaurant;
import com.ekta.myapp.pojo.RestaurantTable;


@Controller

public class AddTableController {
	
	@RequestMapping(value="addTable.htm",method = RequestMethod.POST)
	protected ModelAndView doSubmitAction(@ModelAttribute("addingTable") RestaurantTable restTable,HttpServletRequest request) throws Exception {
//		validator.validate(user, result);
//		if (result.hasErrors()) {
//			return "addUserForm";
//		}
        ModelAndView mv = new ModelAndView();
		try {
			
			String restName=request.getParameter("restName");
			int tableNumber = Integer.parseInt(request.getParameter("tableNo"));
			
			
			
			RestaurantDAO restDAO=new RestaurantDAO();
			Restaurant rest=restDAO.fetchMyRestaurant(restName);
		
			//HttpSession session = request.getSession();
			//System.out.print("test");
			TableDAO tableDAO = new TableDAO();
			RestaurantTable restTab = tableDAO.fetchMyRestaurantTable(tableNumber);
			//System.out.print("test1");
			//Restaurant rest= (Restaurant)session.getAttribute("restSessionObj");
	        //Restaurant rest = (Restaurant) session.getAttribute("restaurant");
			
			
			
			
			if(restTab == null){
			
			RestaurantTable avail=tableDAO.create(restTable.getTableNo(),rest);
			System.out.println("Table avialability is"+avail);
			mv.addObject("tableAdded",avail);
			mv.setViewName("successRestaurantAdded");
			return mv;
			
			// DAO.close();
		} 

		
		else{
			mv.setViewName("successRestaurantAdded");
			System.out.println("You already have this table added to the system");
			return mv;
		}
		}
	
		
		
		catch (ProjException e) {
			System.out.println("Exception: " + e.getMessage());
			mv.setViewName("successRestaurantAdded");
			return mv;
		}

	
	}
	
	@RequestMapping(value="/deleteTable.htm",method = RequestMethod.POST)
	protected String occupiedTable(@ModelAttribute("deletingTable") RestaurantTable restTable,HttpServletRequest request) throws Exception {


		
			
			String restName=request.getParameter("restName");
			RestaurantDAO restDAO=new RestaurantDAO();
			Restaurant rest=restDAO.fetchMyRestaurant(restName);
			System.out.print("ghussa");
			TableDAO tableDAO = new TableDAO();
			int rowsUpdated=tableDAO.update(restTable.getTableNo(), restTable.getTableStatus(), rest);
			System.out.print(rowsUpdated);
			
			
//			RestaurantTable avail=tableDAO.delete(restTable);
//			System.out.println("Table avialability is"+avail);
			
			
			// DAO.close();
		

		return "successRestaurantAdded";
	}
	
	@RequestMapping(value="/updateVacancy.htm",method = RequestMethod.POST)
	protected String vacantTable(@ModelAttribute("updatingTableVacancy") RestaurantTable restTable,HttpServletRequest request) throws Exception {


		
			
			String restName=request.getParameter("restName");
			RestaurantDAO restDAO=new RestaurantDAO();
			Restaurant rest=restDAO.fetchMyRestaurant(restName);
			System.out.print("ghussa");
			TableDAO tableDAO = new TableDAO();
			int rowsUpdated=tableDAO.updateVacancy(restTable.getTableNo(), restTable.getTableStatus(), rest);
			System.out.print(rowsUpdated);
			
			
//			RestaurantTable avail=tableDAO.delete(restTable);
//			System.out.println("Table avialability is"+avail);
			
			
			// DAO.close();
		

		return "successRestaurantAdded";
	}
	
	
	
	

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("tableAdd") Person user) {

		return "successRestaurantAdded";
	}


}
