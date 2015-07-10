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

import com.andela.stockmanager.TableBuilder;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 8519678741940293004L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(name = "companyName")
	private String companyName;

	private String address;

	private String email;

	private String password;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String company) {
		this.companyName = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static void changeToTable(List list) {
		TableBuilder table = new TableBuilder();
		table.addRow("ID", "Name", "Company Name", "Email", "Address");
		table.addRow("______", "______", "________________", "___________",
				"______");

		Iterator<User> user = list.iterator();
		while (user.hasNext()) {
			User singleUser = user.next();
			table.addRow(singleUser.getId().toString(), singleUser.getName(),
					singleUser.getCompanyName(), singleUser.getEmail(),
					singleUser.getAddress());

		}
		System.out.println(table);
	}

}
