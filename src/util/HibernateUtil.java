package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = getSessionFactory();



    private static SessionFactory getSessionFactory(){
        try {
            Configuration configuration = new Configuration().configure("hibernate.cgf.xml");

            return configuration.buildSessionFactory(
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                .build());
        } catch (Throwable ex) {
           System.err.println("Creation failed " + ex);
           throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory SessionFactory(){
        return sessionFactory;
    }
}
