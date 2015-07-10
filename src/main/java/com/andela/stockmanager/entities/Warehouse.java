package com.andela.stockmanager.entities;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.andela.stockmanager.TableBuilder;

@Entity
@Table(name = "warehouses")
public class Warehouse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2837757705198820679L;

	@Id
	@Column(name = "id", columnDefinition = "bigserial")
	@Generated(GenerationTime.INSERT)
	private Long id;

	private String name;
	private String location;
	private String owner;

	public Warehouse() {
	}

	public Warehouse(Long id) {
		if (id != null) {
			this.id = id;
		}
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public static void toTable(List list) {
		TableBuilder table = new TableBuilder();
		table.addRow("ID", "Name", "Location", "Owner");
		table.addRow("______", "__________", "___________", "___________");

		Iterator<Warehouse> warehouses = list.iterator();
		while (warehouses.hasNext()) {
			Warehouse singleWarehouse = warehouses.next();
			table.addRow(singleWarehouse.getId().toString(),
					singleWarehouse.getName(), singleWarehouse.getLocation(),
					singleWarehouse.getOwner());
		}
		System.out.println(table);

	}
}
