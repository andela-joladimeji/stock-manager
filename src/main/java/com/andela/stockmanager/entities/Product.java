package com.andela.stockmanager.entities;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.andela.stockmanager.TableBuilder;

@Entity
@Table(name = "products")
public class Product implements Serializable {

	@Id
	@Column(name = "id", columnDefinition = "bigserial")
	@Generated(GenerationTime.INSERT)
	private Long id;

	public Long getId() {
		return id;
	}

	private static final long serialVersionUID = 5011219745915419290L;

	private String name;
	private String cost;
	private Long numberOfitems;
	private Long warehouseID;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public Long getNumberOfitems() {
		return numberOfitems;
	}

	public void setNumberOfitems(Long numberOfitems) {
		this.numberOfitems = numberOfitems;
	}

	public Long getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(Long warehouseID) {
		this.warehouseID = warehouseID;
	}

	public static void toTable(List list) {

		TableBuilder table = new TableBuilder();
		table.addRow("ID", "Name", "Number of Items", "Warehouse ID", "Cost");
		table.addRow("______", "______", "________________", "___________",
				"______");

	
		Iterator<Product> singleProduct = list.iterator();
		while (singleProduct.hasNext()) {
			Product p = singleProduct.next();
			table.addRow(p.getId().toString(), p.getName(), p
					.getNumberOfitems().toString(), p.getWarehouseID()
					.toString(), p.getCost());

		}
		System.out.println(table);
	}

}
