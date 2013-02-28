package org.javabrains.tutorials;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.tutorials.dto.BasicVehicle;

import java.util.List;

/**
 * Demo AppUserDetails.
 */
public class AppHQL {
    public static void main(String[] args) {
        System.out.println("BEGIN");

        @SuppressWarnings("deprecation")
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from BasicVehicle where id > 5");
        List vehicles = query.list();
        session.getTransaction().commit();
        session.close();

        System.out.println("Amount of BasicVehicle entities: " + vehicles.size());
    }
}
