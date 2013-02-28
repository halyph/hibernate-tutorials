package org.javabrains.tutorials;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.javabrains.tutorials.dto.BasicVehicle;

import java.util.List;

/**
 * Demo AppUserDetails.
 */
public class AppCriteria {
    public static void main(String[] args) {
        System.out.println("BEGIN");

        @SuppressWarnings("deprecation")
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(BasicVehicle.class);
        criteria.add(Restrictions.or(
                Restrictions.like("vehicleName", "%Mercedes1%"),
                Restrictions.gt("id", 3)
        ));

        List<BasicVehicle> basicVehicles = (List<BasicVehicle>) criteria.list();

        printVehicleNames(basicVehicles);

        session.getTransaction().commit();
        session.close();


    }


    private static <T> void printVehicleNames(List<T> vehicleNames) {
        for (T vehicleName : vehicleNames) {
            System.out.println(vehicleName);
        }
    }

}
