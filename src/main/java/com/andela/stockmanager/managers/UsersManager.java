package com.andela.stockmanager.managers;

import java.io.Serializable;
import java.util.List;

import com.andela.stockmanager.entities.User;

public class UsersManager extends DataManager {
	public List getList() {
		return getSession().createCriteria(User.class).list();
	}

	@Override
	public void add(Serializable object) {
		getSession().getTransaction().begin();
		getSession().save(object);
		getSession().getTransaction().commit();
	}

	@Override
	public Serializable get(String id) {
		return (Serializable) getSession().get(User.class, id);
	}

	@Override
	public Boolean delete(String id) {
		getSession().delete(id, User.class);
		return true;
	}

}
