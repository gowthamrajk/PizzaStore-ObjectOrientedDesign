package com.gowthamrajk.pizzastore;

public class Pizza {
	
	private int pizzaId;
	private String pizzaName;
	private double price;
	private String size;
	private Topping topping;
	private PizzaBase pizzaBase;
	
	public Pizza(int pizzaId, String pizzaName, double price, String size, Topping topping, PizzaBase pizzaBase) {
		this.pizzaId = pizzaId;
		this.pizzaName = pizzaName;
		this.price = price;
		this.size = size;
		this.topping = topping;
		this.pizzaBase = pizzaBase;
	}

	public int getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Topping getTopping() {
		return topping;
	}

	public void setTopping(Topping topping) {
		this.topping = topping;
	}

	public PizzaBase getPizzaBase() {
		return pizzaBase;
	}

	public void setPizzaBase(PizzaBase pizzaBase) {
		this.pizzaBase = pizzaBase;
	}

	@Override
	public String toString() {
		
		return "Pizza Details => ID : " + pizzaId + ", Name : " + pizzaName + ", Price : " + price 
				+ ", Size : " + size + topping + pizzaBase;
	}
}
