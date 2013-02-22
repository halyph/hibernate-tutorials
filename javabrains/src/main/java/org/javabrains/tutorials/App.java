package org.javabrains.tutorials;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.tutorials.dto.UserDetails;

import java.util.Date;

/**
 * Demo App.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("BEGIN");

        UserDetails userDetails = new UserDetails();
        userDetails.setUserId(3);
        userDetails.setUserName("Three");
        userDetails.setAddress("Some User Address");
        userDetails.setJointDate(new Date());
        userDetails.setDescription("Some Cool description");


        @SuppressWarnings("deprecation")
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(userDetails);
        session.getTransaction().commit();

        session.close();

    }
}
