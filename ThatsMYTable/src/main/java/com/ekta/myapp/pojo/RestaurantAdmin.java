package com.ekta.myapp.pojo;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="rest_admin_tbl")
@PrimaryKeyJoinColumn(name="personID")
public class RestaurantAdmin extends Person {
	
	@OneToOne(fetch=FetchType.EAGER, mappedBy="restAdmin", cascade=CascadeType.ALL)
	private Restaurant restaurant;
	

	
   
	
	public RestaurantAdmin(){
		
	}





	public Restaurant getRestaurant() {
		return restaurant;
	}





	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	
	
	
	

}
