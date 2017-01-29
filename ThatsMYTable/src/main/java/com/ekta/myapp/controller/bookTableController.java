package com.ekta.myapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ekta.myapp.dao.RestaurantDAO;
import com.ekta.myapp.dao.TableDAO;
import com.ekta.myapp.pojo.Restaurant;
import com.ekta.myapp.pojo.RestaurantTable;

@Controller

public class bookTableController {
	
	@RequestMapping(value="/bookTable.htm",method = RequestMethod.POST)
	protected String occupiedTable(@ModelAttribute("reserve") RestaurantTable restTable,HttpServletRequest request) throws Exception {


		
			
			int tableNo=Integer.parseInt(request.getParameter("tableNo"));
			String restName = request.getParameter("restName");
			RestaurantDAO restDAO=new RestaurantDAO();
			Restaurant rest=restDAO.fetchMyRestaurant(restName);
			
			System.out.print("ghussa");
			TableDAO tableDAO = new TableDAO();
			//RestaurantTable restaurantTable = tableDAO.fetchMyRestaurantTable(Integer.parseInt((tableNo)));
			int rowsUpdated=tableDAO.updateUserTable(tableNo, restTable.getTableStatus(), rest);
			System.out.print(rowsUpdated);
			
			
//			RestaurantTable avail=tableDAO.delete(restTable);
//			System.out.println("Table avialability is"+avail);
			
			
			// DAO.close();
		

		return "successRestaurantAdded";
	}

}
