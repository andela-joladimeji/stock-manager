package com.andela.stockmanager.managers;

import java.io.Serializable;
import java.util.List;

public interface IDataManager {
	public List getList();

	public void add(Serializable object);

	public Serializable get(String id);

	public Boolean delete(String id);
}
