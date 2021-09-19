package com.gowthamrajk.pizzastore;

import java.util.List;

public interface PizzaInterface {
	
	public Pizza addNewPizza(Pizza pizza);
	
	public void deletePizza(Pizza pizza);
	
	public Pizza updatePrice(Pizza pizza, double newPrice);
	
	public List<Pizza> getAllPizzas();
	
	public Pizza orderNewPizza(Pizza pizza, Customer customer);
	
	public Pizza getPizzaByName(String pizzaName) throws PizzaNotFoundException;
	
	public Pizza getPizzaById(int pizzaId) throws PizzaNotFoundException; 
	
	public Pizza getPizzaBySize(String size) throws PizzaNotFoundException;
	
}