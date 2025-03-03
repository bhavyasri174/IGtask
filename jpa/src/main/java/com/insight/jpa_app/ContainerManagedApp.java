package com.insight.jpa_app;

import com.insight.jpaapp.model.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
public class ContainerManagedApp {
	 static EntityManager em = PersistenceManager.getEntityManager();
	 public static  void main(String[] args) {
	    
	        User newUser = new User("madhuri");
	        em.getTransaction().begin();
	        em.persist(newUser);
	        em.getTransaction().commit();
	        System.out.println("User Saved: " + newUser );
	        User foundUser1 = em.find(User.class, newUser.getId()); //2 Managed state
	        System.out.println("User Found: " + foundUser1);
	       
	    }

}
