package com.ekta.myapp.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="restaurant_table_tbl")

public class RestaurantTable {
	@Id
	@GeneratedValue
	@Column(name="tableID",unique=true,nullable=false)
	private int tableID;
	
	@Column(name="tableNo")
	private int tableNo;
	
	@Column(name="tableStatus")
	private String tableStatus;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="restID")
	private Restaurant restaurant;
	
	
	
	public RestaurantTable(){
		
	}

	public int getTableNo() {
		return tableNo;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}

	public int getTableID() {
		return tableID;
	}

	public void setTableID(int tableID) {
		this.tableID = tableID;
	}

	public String getTableStatus() {
		return tableStatus;
	}

	public void setTableStatus(String tableStatus) {
		this.tableStatus = tableStatus;
	}

	
}
