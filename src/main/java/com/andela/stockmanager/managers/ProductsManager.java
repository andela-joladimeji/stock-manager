package com.andela.stockmanager.managers;

import java.io.Serializable;
import java.util.List;

import com.andela.stockmanager.entities.Product;

public class ProductsManager extends DataManager {

	@Override
	public List getList() {
		return getSession().createCriteria(Product.class).list();
	}

	@Override
	public void add(Serializable object) {
		getSession().getTransaction().begin();
		getSession().save(object);
		getSession().getTransaction().commit();
	}

	@Override
	public Serializable get(String id) {
		return (Serializable) getSession().get(Product.class, id);
	}

	@Override
	public Boolean delete(String id) {
		getSession().getTransaction().begin();
		List list = getSession().createQuery("FROM Product where id =" + id)
				.list();

		if (list.size() == 1) {
			getSession().delete(list.iterator().next());
		}
		getSession().getTransaction().commit();
		return true;
	}

}
