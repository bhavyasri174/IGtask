package com.insight.jpa_app;

import com.insight.jpaapp.model.User;

import jakarta.persistence.EntityManager;

public class App {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        // Create (Insert)
        User newUser = new User("John Doe");
        em.getTransaction().begin();
        em.persist(newUser);
        em.getTransaction().commit();
        System.out.println("User Saved: " + newUser);
        User newUser1 = new User("Bhavya");
        em.getTransaction().begin();
        em.persist(newUser1);
        em.getTransaction().commit();
        System.out.println("User1 Saved: " + newUser1);

        // Read (Find)
        User foundUser = em.find(User.class, newUser.getId());
        System.out.println("User Found: " + foundUser);
        User foundUser1 = em.find(User.class, newUser1.getId());
        System.out.println("User1 Found: " + foundUser1);

        // user Update
        em.getTransaction().begin();
        foundUser.setName("John Updated");
        em.getTransaction().commit();
        System.out.println("User Updated: " + foundUser);
        //user1 update
        em.getTransaction().begin();
        foundUser1.setName("Bhavya sri");
        em.getTransaction().commit();
        System.out.println("User1 Updated: " + foundUser1);
        

        // Delete
        em.getTransaction().begin();
        em.remove(foundUser);
        em.getTransaction().commit();
        System.out.println("User Deleted");

        // Close EntityManager
        em.close();
        JPAUtil.close();
    }
}
