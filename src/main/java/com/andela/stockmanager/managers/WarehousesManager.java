package com.andela.stockmanager.managers;

import java.io.Serializable;
import java.util.List;

import com.andela.stockmanager.entities.Warehouse;

public class WarehousesManager extends DataManager {

	@Override
	public List getList() {
		return getSession().createCriteria(Warehouse.class).list();
	}

	@Override
	public void add(Serializable object) {
		getSession().getTransaction().begin();
		getSession().save(object);
		getSession().getTransaction().commit();
	}

	@Override
	public Serializable get(String id) {
		return (Serializable) getSession().get(Warehouse.class, id);
	}

	@Override
	public Boolean delete(String id) {
		getSession().getTransaction().begin();

		List list = getSession().createQuery("FROM Warehouse where id =" + id)
				.list();
		if (list.size() == 1) {
			System.out.println("Record found and will be deleted");
			getSession().delete(list.iterator().next());
		}

		getSession().getTransaction().commit();
		return true;
	}
}
