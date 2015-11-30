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
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static{
        /*try{
            /*sessionFactory = /*new Configuration()
                    .addPackage("de.hska.vis.webshop.model")
                    .addAnnotatedClass(User.class)
                    .configure()
                    .buildSessionFactory();
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }*/
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
        /*try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
            System.out.println("Initial SessionFactory creation");
        } catch (Throwable ex) {
            System.out.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }*/
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
