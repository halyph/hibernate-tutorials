package org.javabrains.tutorials;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.tutorials.dto.BasicVehicle;
import org.javabrains.tutorials.dto.FourWheeler;
import org.javabrains.tutorials.dto.Role;
import org.javabrains.tutorials.dto.TwoWheeler;
import org.javabrains.tutorials.dto.User;
import org.javabrains.tutorials.dto.Vehicle;

/**
 * Demo AppUserDetails.
 */
public class AppVehicle {
    public static void main(String[] args) {
        System.out.println("BEGIN");

        @SuppressWarnings("deprecation")
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        BasicVehicle basicVehicle = new BasicVehicle();
        basicVehicle.setVehicleName("Car");

        TwoWheeler twoWheeler = new TwoWheeler();
        twoWheeler.setVehicleName("Bike");
        twoWheeler.setSteeringHandle("Bike setSteeringHandle");


        FourWheeler fourWheeler = new FourWheeler();
        fourWheeler.setVehicleName("Vaz");
        fourWheeler.setSteeringWheel("Vaz setSteeringWheel");
        fourWheeler.setWheelType("Whinter");

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(basicVehicle);
        session.save(twoWheeler);
        session.save(fourWheeler);

        session.getTransaction().commit();
        session.close();

    }
}
