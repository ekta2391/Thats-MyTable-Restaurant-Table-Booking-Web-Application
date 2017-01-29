package com.ekta.myapp.dao;



import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.ekta.myapp.exception.ProjException;
import com.ekta.myapp.pojo.Restaurant;
import com.ekta.myapp.pojo.RestaurantTable;

public class TableDAO extends DAO{
	
	public TableDAO(){
		
	}
	
	public RestaurantTable create(int tableNo,Restaurant restaurant)
            throws ProjException {
        try {
            begin();
            System.out.println("inside TableDAO");
            
            
            RestaurantTable restTable = new RestaurantTable();
            
           restTable.setTableNo(tableNo);
           restTable.setTableStatus("vacant");
           restTable.setRestaurant(restaurant);
           //restAdmin.setRestaurant(rest);
            
            //getSession().merge(restAdmin);
            getSession().merge(restTable);
            commit();
            return restTable;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create restaurant " + restName, e);
            throw new ProjException("Exception while creating restaurant: " + e.getMessage());
        }
    }
	
	 public int update(int tableNo,String tableStatus, Restaurant rest)
	            throws ProjException {
	        try {
	            begin();
	            
	            
	            Query q = getSession().createQuery("update RestaurantTable set tableStatus =:tableStatus where tableNo =:tableNo");
	            q.setString("tableStatus",tableStatus);
	            q.setInteger("tableNo", tableNo);
	            int result = q.executeUpdate();
	            
	            
	            //RestaurantTable restTable = restTable.getTableNo();
	            //getSession().delete(restTable);
	            
	            commit();
	            return result;
	            
	        } catch (HibernateException e) {
	            rollback();
	            throw new ProjException("Could not update table occupancy " , e);
	            
	        }
	    }
	 
	 public int updateVacancy(int tableNo,String tableStatus, Restaurant rest)
	            throws ProjException {
	        try {
	            begin();
	            
	            
	            Query q = getSession().createQuery("update RestaurantTable set tableStatus =:tableStatus where tableNo =:tableNo");
	            q.setString("tableStatus",tableStatus);
	            q.setInteger("tableNo", tableNo);
	            int result = q.executeUpdate();
	            
	            
	            //RestaurantTable restTable = restTable.getTableNo();
	            //getSession().delete(restTable);
	            
	            commit();
	            return result;
	            
	        } catch (HibernateException e) {
	            rollback();
	            throw new ProjException("Could not update table occupancy " , e);
	            
	        }
	    }
	 
	 public int updateUserTable(int tableNo,String tableStatus, Restaurant rest)
	            throws ProjException {
	        try {
	            begin();
	            
	            
	            Query q = getSession().createQuery("update RestaurantTable set tableStatus =:tableStatus where tableNo =:tableNo");
	            q.setString("tableStatus",tableStatus);
	            q.setInteger("tableNo",tableNo);
	            int result = q.executeUpdate();
	            
	            
	            //RestaurantTable restTable = restTable.getTableNo();
	            //getSession().delete(restTable);
	            
	            commit();
	            return result;
	            
	        } catch (HibernateException e) {
	            rollback();
	            throw new ProjException("Could not update table occupancy " , e);
	            
	        }
	    }
	 
	 public RestaurantTable fetchMyRestaurantTable(int tableNo)
	    {
	    	try {
	            begin();
	            Query q = getSession().createQuery("from RestaurantTable where tableNo=:tableNo");
	            q.setParameter("tableNo",tableNo);
	            RestaurantTable restaurantTable =(RestaurantTable) q.uniqueResult();
	            commit();
	            return restaurantTable;
	           
	        } catch (HibernateException e) {
	            rollback();
	           // throw new ProjException("Could not find match " + e.getMessage());
	            return null;
	            
	        }
	    
	    }

}
