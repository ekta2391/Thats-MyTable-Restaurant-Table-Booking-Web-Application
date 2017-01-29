package com.ekta.myapp.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="restaurant_tbl")
public class Restaurant {

	public Restaurant(){
		
	}
	
	@Id
	@GeneratedValue
	@Column(name="restID")
	private int restID;
	
	@Column(name="restName")
	private String restName;
	
	@Column(name="restCity")
	private String restCity;
	
	@Column(name="zipCode")
	private int zipCode;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="restAdminID")
	private RestaurantAdmin restAdmin;
	

	@OneToMany(fetch=FetchType.EAGER, mappedBy="restaurant",cascade=CascadeType.ALL)
	List <RestaurantTable> restTable = new ArrayList<RestaurantTable>();
	
	
	
	
	
	public List<RestaurantTable> getRestTable() {
		return restTable;
	}
	public void setRestTable(List<RestaurantTable> restTable) {
		this.restTable = restTable;
	}
	public RestaurantAdmin getRestAdmin() {
		return restAdmin;
	}
	public void setRestAdmin(RestaurantAdmin restAdmin) {
		this.restAdmin = restAdmin;
	}
	public int getRestID() {
		return restID;
	}
	public void setRestID(int restID) {
		this.restID = restID;
	}
	public String getRestName() {
		return restName;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}
	public String getRestCity() {
		return restCity;
	}
	public void setRestCity(String restCity) {
		this.restCity = restCity;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	
}
