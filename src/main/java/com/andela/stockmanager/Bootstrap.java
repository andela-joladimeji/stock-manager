package com.andela.stockmanager;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import com.andela.stockmanager.entities.Product;
import com.andela.stockmanager.entities.User;
import com.andela.stockmanager.entities.Warehouse;
import com.andela.stockmanager.managers.AuthenticationManager;
import com.andela.stockmanager.managers.ProductsManager;
import com.andela.stockmanager.managers.UsersManager;
import com.andela.stockmanager.managers.WarehousesManager;
import com.sun.corba.se.spi.orbutil.fsm.Action;

public class Bootstrap {

	private static Boolean initialized = false;

	public Bootstrap() {
		// TODO Auto-generated constructor stub
	}

	private void authenticate() {
		while (!AuthenticationManager.getInstance().authenticated) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter your email => ");
			String email = scanner.next();

			System.out.println("Enter your password => ");
			String password = scanner.next();

			System.out.print(String.format("%s = %s", email, password));
			AuthenticationManager.getInstance().authenticate(email, password);
		}
		System.out.println("Authentication successfull");
		listOptions();
	}

	/*
	 * Available actions product.list product.add product.delete warehouse.list
	 * warehouse.add warehouse.delete user.list
	 */
	private void listOptions() {
		Scanner scanner = new Scanner(System.in);
		// reflection
		Field[] fields = Actions.class.getDeclaredFields();

		for (Field field : fields) {
			try {
				System.out.println("Select an action => " + field.get(null));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String userAction = scanner.nextLine();
		UsersManager usersManager = new UsersManager();
		ProductsManager productsManager = new ProductsManager();
		WarehousesManager warehousesManager = new WarehousesManager();

		switch (userAction) {
		case "user.list":
			List users = usersManager.getList();
			User.changeToTable(users);

			break;

		case "product.list":
			List products = productsManager.getList();

			System.out.println("Products Table");
			Product.toTable(products);

			break;

		case "product.save":
			Product product = new Product();

			while (StringUtils.isBlank(product.getName())
					&& product.getNumberOfitems() == null
					&& StringUtils.isBlank(product.getCost())
					&& product.getWarehouseID() == null) {

				System.out.println("Cost:");
				String cost = scanner.nextLine();

				System.out.println("Name:");
				String name = scanner.nextLine();

				System.out.println("Number of Items:");
				Long numberOfitems = scanner.nextLong();

				System.out.println("Warehouse ID:");
				Long warehouseID = scanner.nextLong();

				product.setCost(cost);
				product.setName(name);
				product.setNumberOfitems(numberOfitems);
				product.setWarehouseID(warehouseID);
				productsManager.add(product);
			}

			break;

		case "product.delete":
			List productList = productsManager.getList();

			System.out.println("Select Product to be deleted From this list");

			Product.toTable(productList);

			// System.out.println("Enter Product ID:");
			Long productID = scanner.nextLong();

			productsManager.delete(productID.toString());

			break;

		case "warehouse.list":
			List listOfWarehouse = warehousesManager.getList();
			Warehouse.toTable(listOfWarehouse);
			break;

		case "warehouse.save":
			Warehouse warehouse = new Warehouse(null);

			while (StringUtils.isBlank(warehouse.getName())
					&& StringUtils.isBlank(warehouse.getLocation())
					&& StringUtils.isBlank(warehouse.getOwner())) {
				
				System.out.println("Enter Warehouse Name:");
				String warehouseName = scanner.nextLine();

				System.out.println("Warehouse Location:");
				String location = scanner.nextLine();

				System.out.println("Owner of Warehouse:");
				String owner = scanner.nextLine();

				warehouse.setName(warehouseName);
				warehouse.setLocation(location);
				warehouse.setOwner(owner);

				warehousesManager.add(warehouse);
			}
			break;

		case "warehouse.delete":

			List warehouseList = warehousesManager.getList();
			Warehouse.toTable(warehouseList);
			
			System.out.println("Choose Warehouse ID");
			String warehouseID = scanner.nextLine();
			warehousesManager.delete(warehouseID.toString());

			break;

		default:
			System.out.println("Please select from the above listed options");
			break;
		}

		System.out.print("Type 'c' then enter to continue");
		String continues = scanner.nextLine();
		listOptions();
	}

	public void init() {
		if (!Bootstrap.initialized) {
			Bootstrap.initialized = true;
			authenticate();
		}
	}
}
