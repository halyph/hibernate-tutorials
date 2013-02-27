package org.javabrains.tutorials;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.tutorials.dto.Role;
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

        Role role1 = new Role();
        role1.setRoleName("Admin");
        Role role2 = new Role();
        role2.setRoleName("Client");

        User user = new User();
        user.setUserName("Super Man");
        user.getVehicle().add(vehicle);
        user.getVehicle().add(vehicle2);
        vehicle.setUser(user);
        vehicle2.setUser(user);

        user.getRole().add(role1);
        user.getRole().add(role2);

        role1.getUsers().add(user);
        role2.getUsers().add(user);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(user);
//        session.save(vehicle);
//        session.save(vehicle2);
        session.save(role1);
        session.save(role2);

        session.getTransaction().commit();

        session.close();

        vehicle = null;

        session = sessionFactory.openSession();
        session.beginTransaction();
        vehicle = (Vehicle) session.get(Vehicle.class, 1);

        System.out.format("User name is %s", vehicle.getUser().getUserName());

    }
}
