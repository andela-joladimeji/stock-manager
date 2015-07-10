package com.andela.stockmanager.managers;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import com.andela.stockmanager.PostgresHibernate;
import com.andela.stockmanager.entities.User;

public class AuthenticationManager {

	private static AuthenticationManager authentication;

	public Boolean authenticated = false;

	private AuthenticationManager() {

	}

	public static AuthenticationManager getInstance() {
		if (authentication == null) {
			authentication = new AuthenticationManager();
		}

		return authentication;
	}

	public Boolean authenticate(String email, String password) {
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		Example example = Example.create(user);
		Criteria criteria = getSession().createCriteria(User.class)
				.add(example);
		authenticated = criteria.list().size() == 1;
		return authenticated;

	}

	protected Session getSession() {
		return PostgresHibernate.getInstance().session;
	}

}
