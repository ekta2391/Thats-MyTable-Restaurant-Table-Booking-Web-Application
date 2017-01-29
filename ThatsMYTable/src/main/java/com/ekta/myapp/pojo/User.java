package com.ekta.myapp.pojo;

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
@Table(name="user_tbl")
@PrimaryKeyJoinColumn(name="personID")
public class User extends Person {
	
	
	
	
	
	public User(){
		
	}
	
	
	

}
