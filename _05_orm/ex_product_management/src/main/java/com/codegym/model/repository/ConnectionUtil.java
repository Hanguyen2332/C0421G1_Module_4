package com.codegym.model.repository;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class ConnectionUtil {
    public static EntityManager entityManager;

    public static SessionFactory sessionFactory;
    static {
        try{
            sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
//            sessionFactory.close();
        }catch (HibernateException ex) {
            ex.printStackTrace();
        }
    }
}
