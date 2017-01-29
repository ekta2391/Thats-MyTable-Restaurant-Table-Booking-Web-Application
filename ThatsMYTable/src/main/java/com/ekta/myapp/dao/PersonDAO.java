package com.ekta.myapp.dao;





import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.ekta.myapp.exception.ProjException;
import com.ekta.myapp.pojo.Person;
import com.ekta.myapp.pojo.User;



public class PersonDAO extends DAO{
	public PersonDAO() {
    }

    public Person get(String username,String password)
            throws ProjException {
        try {
            begin();
            Query q = getSession().createQuery("from Person where username = :username AND password = :password ");
            q.setString("username", username);
            q.setString("password", password);
            
        
            Person person = (Person) q.uniqueResult();
           commit();
            return person;
           
        } catch (HibernateException e) {
            rollback();
            throw new ProjException("Could not Login. Check if username and password are correctly entered " + e.getMessage());
            
            
        }
        
       
    }

   

}
