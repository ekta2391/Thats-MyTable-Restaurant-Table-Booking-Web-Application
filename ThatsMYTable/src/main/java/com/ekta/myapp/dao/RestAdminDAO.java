package com.ekta.myapp.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.ekta.myapp.exception.ProjException;
import com.ekta.myapp.pojo.Person;
import com.ekta.myapp.pojo.RestaurantAdmin;

public class RestAdminDAO extends DAO {

	public RestAdminDAO(){
		
	}
	
	 public RestaurantAdmin create(String firstName, String lastName,String city,String username,String password,String roleType)
	            throws ProjException {
		 
		 if(findRestAdmin(username)){
			 
			 System.out.println("Username already exists");
			return null; 
		 }
		 else{
			 
			 try {
	            begin();
	            System.out.println("inside DAO");
	            
	            
	            RestaurantAdmin restAd=new RestaurantAdmin();
	            
	            restAd.setFirstName(firstName);
	            restAd.setLastName(lastName);
	            
	            restAd.setCity(city);
	            restAd.setUsername(username);
	            restAd.setPassword(password);
	            restAd.setRoleType(roleType);
	            
	            getSession().save(restAd);
	            
	            commit();
	            return restAd;
	        } 
		 
		 
		 catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create user " + username, e);
	            throw new ProjException("Exception while creating user: " + e.getMessage());
	        }
	    }
	 }

	    public void delete(RestaurantAdmin restAd)
	            throws ProjException {
	        try {
	            begin();
	            getSession().delete(restAd);
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new ProjException("Could not delete user " + restAd.getUsername(), e);
	        }
	    }
	    
	    public boolean findRestAdmin(String username){
	    	begin();
	    	Query q = getSession().createQuery("from Person where username=:username");
	    	q.setString("username", username);
	    	Person person = (Person) q.uniqueResult();
	    	if(person!=null){
	    		
	    		return true;
	    		
	    	}
	    	
	    	else{
	    		return false;
	    	}
	    	
	    }
	
}
