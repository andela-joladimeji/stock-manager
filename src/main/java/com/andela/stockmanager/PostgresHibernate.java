package com.andela.stockmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.andela.stockmanager.entities.User;

public class PostgresHibernate {

	public Session session;

	private static PostgresHibernate instance = null;

	protected PostgresHibernate() {
		SessionFactory sessionFactory = new Configuration().configure(
				"hibernate.cfg.xml").buildSessionFactory();

		session = sessionFactory.openSession();
	}

	public void beginTransaction() {
		session.beginTransaction();
	}

	public static PostgresHibernate getInstance() {
		if (instance == null) {
			instance = new PostgresHibernate();
		}
		return instance;
	}

}
