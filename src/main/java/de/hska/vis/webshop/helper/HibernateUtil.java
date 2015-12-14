package de.hska.vis.webshop.helper;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import de.hska.vis.webshop.model.User;
import org.slf4j.Logger;

/**
 * Created by Christian on 26.11.2015.
 * This class is used to create and access the SessionFactory object.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static{

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    /**
     * Get the SessionFactory object
     * @return the SessionFactory
     */
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
