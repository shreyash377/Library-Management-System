package com.demo.Library_Management_System;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.Library_Management_System.entities.Member;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
		try {
			return new
					Configuration().configure("Hibernate.cfg.xml").addAnnotatedClass(Member.class)
					.buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
