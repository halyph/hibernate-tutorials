package org.javabrains.tutorials;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.tutorials.dto.User;
import org.javabrains.tutorials.dto.Vehicle;

/**
 * Demo AppUserDetails.
 */
public class AppUser {
    public static void main(String[] args) {
        System.out.println("BEGIN");

        @SuppressWarnings("deprecation")
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");

        User user = new User();
        user.setUserName("Super Man");
        user.setVehicle(vehicle);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(user);
        session.save(vehicle);

        session.getTransaction().commit();

        session.close();

        user = null;

        session = sessionFactory.openSession();
        session.beginTransaction();
        user = (User) session.get(User.class, 1);

        System.out.format("User name is %s", user.getUserName());

    }
}
