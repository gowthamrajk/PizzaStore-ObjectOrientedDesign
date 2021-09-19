package com.gowthamrajk.pizzastore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	private int customerId;
	private String customerName;
	private String email;
	private long mobile;
	private Address address;
	private List<Order> orders = new ArrayList<>();
	
	public Customer(int customerId, String customerName, String email, long mobile, Address address) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}
	
	public void addOrder(Order order) {
		this.orders.add(order);
	}
	
	public double getPayableAmount() {
		
		double payableAmount = 0;
		for(Order orderObj : orders) {
			payableAmount += orderObj.getPayableBillAmount();
		}
		
		return payableAmount;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		
		return "Customer Details => ID : " + customerId + ", Name : " + customerName + ", Email : " + email
				+ ", Mobile : " + mobile + address;
	}
}
