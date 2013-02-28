package org.javabrains.tutorials;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.tutorials.dto.BasicVehicle;

/**
 * Demo AppUserDetails.
 */
public class AppCRUD {
    public static void main(String[] args) {
        System.out.println("BEGIN");

        @SuppressWarnings("deprecation")
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Step 1 - Creating entities
        // createBunchOfVehicles(session);

        // Step 2 - Fetching just created entity and delete it
        // BasicVehicle basicVehicle = (BasicVehicle) session.get(BasicVehicle.class, 7);
        // System.out.format("Vehicle name is <%s>\n", basicVehicle.getVehicleName());
        // session.delete(basicVehicle);

        // Step 3 - Update
        BasicVehicle basicVehicle = (BasicVehicle) session.get(BasicVehicle.class, 5);
        basicVehicle.setVehicleName("BMW X3");
        session.update(basicVehicle);


        session.getTransaction().commit();
        session.close();
    }

    private static void createBunchOfVehicles(Session session) {
        for (int i = 1; i < 11  ; i++) {
            BasicVehicle basicVehicle = new BasicVehicle("Mercedes" + i);
            session.save(basicVehicle);
        }
    }
}
