package com.gowthamrajk.pizzastore;

import java.util.List;
import java.util.ArrayList;

public class Order {
	
	private int orderId;
	private String orderDate;
	private double payableBillAmount;
	private String orderDescription;
	private List<Pizza> pizzas = new ArrayList<>();
	
	public Order() { }
	
	public Order(int orderId, String orderDate, double payableBillAmount, String orderDescription) {
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.payableBillAmount = payableBillAmount;
		this.orderDescription = orderDescription;
	}
	
	public void addPizza(Pizza pizza) {
		this.pizzas.add(pizza);
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public double getPayableBillAmount() {
		return payableBillAmount;
	}

	public void setPayableBillAmount(double payableBillAmount) {
		this.payableBillAmount = payableBillAmount;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	@Override
	public String toString() {
		
		return "Order Details : Id : " + orderId + ", Date : " + orderDate + ", Bill Amount : " 
		       + payableBillAmount + ", Description : " + orderDescription 
		       + "\nPizzas in this specific Order : \n " + pizzas;
	}
}
