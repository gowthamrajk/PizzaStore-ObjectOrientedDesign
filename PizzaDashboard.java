package com.gowthamrajk.pizzastore;

import java.util.Scanner;

public class PizzaDashboard {

	public static void main(String[] args) {

		PizzaStore pizzaStore = new PizzaStore(1, "Pizza Spot", "Coimbatore");
		PizzaInterface pizzaService = new PizzaService(pizzaStore);

		try (Scanner scanner = new Scanner(System.in)) {

			while (true) {
				System.out.println("Hey Buddy, Welcome to Gowthamraj's Pizza Spot !!!\n");
				System.out.println("choose your Role to Login : \n1) ADMIN \n2) CUSTOMER");
				int roleOption = scanner.nextInt();
				if (roleOption == 1) {
					System.out.println("Welcome to ADMIN console !!!");
					openAdminRole(scanner, pizzaService);
				} else if (roleOption == 2) {
					System.out.println("Welcome to CUSTOMER console !!!");
					openCustomerRole(scanner, pizzaService);
				}
				else {
					System.out.println("Thankyou !!!");
					break;
				}
			}
		} catch (Exception exception) {
			System.err.println(exception);
		}
	}

	public static void openAdminRole(Scanner scanner, PizzaInterface pizzaService) {

		while (true) {

			System.out.println("choose an Option : \n1) Add Pizza \n2) Update Price \n3) Delete Pizza "
					+ "\n4) View All Pizza \n5) Search Pizza \n6) Exit");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {

			case 1: {

				System.out.println("\n<=>Add New Pizza Menu<=>\n");
				System.out.println(
						"Enter Details as name of Topping, spice level(basic/mediate/full), description to add a new Topping...");
				String[] pizzaTopping = scanner.nextLine().split(",");
				Topping topping = new Topping(pizzaTopping[0], pizzaTopping[1], pizzaTopping[2]);

				System.out.println(
						"Enter Details as name of Base, type(thin/thick), description to add a new PizzaBase...");
				String[] pizzaBases = scanner.nextLine().split(",");
				PizzaBase pizzaBase = new PizzaBase(pizzaBases[0], pizzaBases[1], pizzaBases[2]);

				System.out.println(
						"Enter Details as name of Pizza, price, size(small/Medium/Large) to add a new Pizza...");
				String[] pizzaDetails = scanner.nextLine().split(",");
				Pizza pizza = new Pizza(1, pizzaDetails[0], Double.parseDouble(pizzaDetails[1]), pizzaDetails[2],
						topping, pizzaBase);

				pizzaService.addNewPizza(pizza);
				System.out.println("New Pizza Added Successfully !!!\n\n" + pizza + "\n");
				break;
			}
			case 2: {

				System.out.println("\n<=>Update Pizza Menu<=>\n");
				System.out.println("Enter Pizza name : ");
				String pizzaName = scanner.next();
				System.out.println("Enter New price to be updates : ");
				double price = scanner.nextDouble();

				try {
					System.out.println("Pizza Details updated Successfully !!!"
							+ pizzaService.updatePrice(pizzaService.getPizzaByName(pizzaName), price));
				} catch (PizzaNotFoundException exception) {
					System.err.println(exception);
				}
				break;
			}
			case 3: {

				System.out.println("\n<=>Delete Pizza Menu<=>\n");
				System.out.println("Enter Pizza name : ");
				String pizzaName = scanner.next();

				try {
					pizzaService.deletePizza(pizzaService.getPizzaByName(pizzaName));
				} catch (PizzaNotFoundException exception) {
					System.err.println(exception);
				}

				System.out.println("Pizza Deleted Successfully !!!");
				break;
			}
			case 4: {

				System.out.println("\n<=>View All Pizza Menu<=>\n");
				int counter = 1;
				for (Pizza pizzaObj : pizzaService.getAllPizzas()) {
					System.out.println("Pizza Number " + counter + " :\n" + pizzaObj + "\n");
					counter++;
				}
				break;
			}
			case 5: {

				System.out.println("\n<=>Search Pizza Menu<=>\n");
				searchPizza(scanner, pizzaService);
				break;
			}
			case 6: {
				System.out.println("Thankyou ADMIN !!!");
				return;
			}
			default: {
				System.out.println("Invalid Option, Try again !!!");
				break;
			}
			}
		}
	}

	public static void openCustomerRole(Scanner scanner, PizzaInterface pizzaService) {

		scanner.nextLine();
		System.out.println("\nEnter your doorNumber, street, city, district, state...");
		String[] addressDetails = scanner.nextLine().split(",");
		Address address = new Address(Integer.parseInt(addressDetails[0]), addressDetails[1], addressDetails[2],
				addressDetails[3], addressDetails[4]);

		System.out.println("Enter your Details as name, email, mobile...");
		String[] customerDetails = scanner.nextLine().split(",");
		Customer customer = new Customer(11, customerDetails[0], customerDetails[1], Long.parseLong(customerDetails[2]),
				address);
		System.out.println("We added you as our New customer...\n" + customer);

		while (true) {

			System.out.println("choose an Option : \n1) Order Pizza \n2) Pay Bill \n3) View All Pizza "
					+ "\n4) View your Orders \n5) Search Pizza \n6) Exit");
			int choice = scanner.nextInt();
			switch (choice) {

			case 1: {

				System.out.println("\n<=>Order New Pizza Menu<=>\n");
				System.out.println("Available Pizzas : \n" + pizzaService.getAllPizzas());
				System.out.println("\nEnter Pizza Name to Place your Order : ");
				String pizzaName = scanner.next();
				try {
					System.out.println("\nYour order has been successfully placed !!!\n\n" 
				             + pizzaService.orderNewPizza(pizzaService.getPizzaByName(pizzaName), customer));
				} catch (PizzaNotFoundException exception) {
					System.err.println(exception);
				}
				break;
			}
			case 2: {

				System.out.println("\n<=>Check your order's Bill Amount here...<=>\n");
				System.out.println("\nYour Payable Bill Amount for all your orders is Rs: "
						+ customer.getPayableAmount() + " INR\n");

				break;
			}
			case 3: {

				System.out.println("\n<=>View All Pizza Menu<=>\n");
				int counter = 1;
				for (Pizza pizzaObj : pizzaService.getAllPizzas()) {
					System.out.println("Pizza Number " + counter + " :\n" + pizzaObj + "\n");
					counter++;
				}
				break;
			}
			case 4: {
				System.out.println("\n<=>View your orders Menu<=>\n");
				System.out.println("Your Orders : \n" + customer.getOrders() + "\n");
				break;
			}
			case 5: {

				System.out.println("\n<=>Search Pizza Menu<=>\n");
				searchPizza(scanner, pizzaService);
				break;
			}
			case 6: {
				System.out.println("Thankyou CUSTOMER !!! Visit Again !!!");
				return;
			}
			default: {
				System.out.println("Invalid Option, Try again !!!");
				break;
			}
			}
		}
	}

	public static void searchPizza(Scanner scanner, PizzaInterface pizzaService) {

		System.out.println("Choose your Search Type : \n1) Search by Name \n2) Search by ID \n3) Search by Size");
		int searchOption = scanner.nextInt();

		if (searchOption == 1) {
			System.out.println("Enter Pizza Name to search : ");
			String pizzaName = scanner.next();
			try {
				System.out.println("\n" + pizzaService.getPizzaByName(pizzaName) + "\n");
			} catch (PizzaNotFoundException exception) {
				System.err.println(exception);
			}
		} else if (searchOption == 2) {
			System.out.println("Enter Pizza ID to search : ");
			int pizzaId = scanner.nextInt();
			try {
				System.out.println("\n" + pizzaService.getPizzaById(pizzaId) + "\n");
			} catch (PizzaNotFoundException exception) {
				System.err.println(exception);
			}

		} else if (searchOption == 3) {
			System.out.println("Enter Pizza Size to search : ");
			String pizzaSize = scanner.next();
			try {
				System.out.println("\n" + pizzaService.getPizzaBySize(pizzaSize) + "\n");
			} catch (PizzaNotFoundException exception) {
				System.err.println(exception);
			}
		} else
			System.out.println("Invalid Option !!!");
	}

}
