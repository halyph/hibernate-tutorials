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

        List<String> vehicleNames = selectVehicleName(session);

        List<BasicVehicle> vehicles = selectBasicVehicles(session);

        session.getTransaction().commit();
        session.close();

        System.out.println("Amount of BasicVehicle names: " + vehicleNames.size());
        printVehicleNames(vehicleNames);

        System.out.println("\nAmount of BasicVehicle entities: " + vehicles.size());
        printVehicleNames(vehicles);

    }

    private static List<BasicVehicle> selectBasicVehicles(Session session) {
        Query query = session.createQuery("from BasicVehicle where id > :minId");
        query.setInteger("minId", 3);
        return (List<BasicVehicle>) query.list();
    }

    private static <T> void printVehicleNames(List<T> vehicleNames) {
        for (T vehicleName : vehicleNames) {
            System.out.println(vehicleName);
        }
    }

    private static List<String> selectVehicleName(Session session) {
        Query query = session.createQuery("select vehicleName from BasicVehicle");
        query.setFirstResult(2);
        query.setMaxResults(2);

        return (List<String>) query.list();
    }
}
