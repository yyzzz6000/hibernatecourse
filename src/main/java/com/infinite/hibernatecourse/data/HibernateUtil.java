package com.infinite.hibernatecourse.data;

import com.infinite.hibernatecourse.data.entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by yangweny on 28/01/2018.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class)
                     .addAnnotatedClass(TimeTest.class)
                     .addAnnotatedClass(Bank.class)
                     .addAnnotatedClass(Credential.class)
                     .addAnnotatedClass(Transaction.class)
                     .addAnnotatedClass(Budget.class)
                     .addAnnotatedClass(Account.class);
        return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

