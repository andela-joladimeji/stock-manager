/**
 * 
 */
package com.andela.stockmanager.managers;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.andela.stockmanager.PostgresHibernate;

/**
 * @author oladimejiolajumoke
 * 
 */
public abstract class DataManager implements IDataManager {

	/**
	 * 
	 */
	public DataManager() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.andela.stockmanager.managers.IDataManager#getList()
	 */
	public abstract List getList();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.andela.stockmanager.managers.IDataManager#add(java.io.Serializable)
	 */
	public abstract void add(Serializable object);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.andela.stockmanager.managers.IDataManager#get(java.lang.Integer)
	 */
	public abstract Serializable get(String id);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.andela.stockmanager.managers.IDataManager#delete(java.lang.Integer)
	 */
	public abstract Boolean delete(String id);

	protected Session getSession() {
		return PostgresHibernate.getInstance().session;
	}

}
