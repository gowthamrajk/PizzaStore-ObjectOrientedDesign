package com.gowthamrajk.pizzastore;

import java.util.List;

public class PizzaService implements PizzaInterface {

	private PizzaStore pizzaStore = new PizzaStore();
	private String pizzaNotFoundMessage = "Pizza with the given name is Not Available !!!";
	
	public PizzaService(PizzaStore pizzaStore) {
		this.pizzaStore = pizzaStore;
	}
	
	@Override
	public Pizza addNewPizza(Pizza pizza) {	
		pizzaStore.addPizza(pizza);
		return null;
	}

	@Override
	public void deletePizza(Pizza pizza) {		
		pizzaStore.deletePizza(pizza);
	}

	@Override
	public Pizza updatePrice(Pizza pizza, double newPrice) {	
		pizza.setPrice(newPrice);
		return pizza;
	}

	@Override
	public List<Pizza> getAllPizzas() {
		return pizzaStore.getPizzas();
	}

	@Override
	public Pizza orderNewPizza(Pizza pizza, Customer customer) {
		
		Order order = new Order(21, "18-09-2021", pizza.getPrice(), "spicy");
		order.addPizza(pizza);
		customer.addOrder(order);
		pizzaStore.addCustomer(customer);
		return pizza;
	}

	@Override
	public Pizza getPizzaByName(String pizzaName) throws PizzaNotFoundException {
		
		Pizza pizza = null;
		for(Pizza pizzaObj : pizzaStore.getPizzas()) {
			if(pizzaObj.getPizzaName().equalsIgnoreCase(pizzaName)) {
				pizza = pizzaObj;
			}
		}
		
		if(pizza == null)
			throw new PizzaNotFoundException(pizzaNotFoundMessage);
		
		return pizza;
	}

	@Override
	public Pizza getPizzaById(int pizzaId) throws PizzaNotFoundException {
		
		Pizza pizza = null;
		for(Pizza pizzaObj : pizzaStore.getPizzas()) {
			if(pizzaObj.getPizzaId() == pizzaId) {
				pizza = pizzaObj;
			}
		}
		
		if(pizza == null)
			throw new PizzaNotFoundException(pizzaNotFoundMessage);
		
		return pizza;
	}

	@Override
	public Pizza getPizzaBySize(String size) throws PizzaNotFoundException {
		
		Pizza pizza = null;
		for(Pizza pizzaObj : pizzaStore.getPizzas()) {
			if(pizzaObj.getSize().equalsIgnoreCase(size)) {
				pizza = pizzaObj;
			}
		}
		
		if(pizza == null)
			throw new PizzaNotFoundException(pizzaNotFoundMessage);
		
		return pizza;
	}

}
