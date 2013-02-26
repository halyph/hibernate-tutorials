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

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleName("BMW");

        User user = new User();
        user.setUserName("Super Man");
        user.getVehicle().add(vehicle);
        user.getVehicle().add(vehicle2);
        vehicle.setUser(user);
        vehicle2.setUser(user);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(user);
        session.save(vehicle);
        session.save(vehicle2);

        session.getTransaction().commit();

        session.close();

        vehicle = null;

        session = sessionFactory.openSession();
        session.beginTransaction();
        vehicle = (Vehicle) session.get(Vehicle.class, 1);

        System.out.format("User name is %s", vehicle.getUser().getUserName());

    }
}
