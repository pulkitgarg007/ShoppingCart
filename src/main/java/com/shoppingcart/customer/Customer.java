package com.shoppingcart.customer;

public class Customer {
	
	private CustomerType customerType;
	
	private String firstName;
	private String lastName;
	
	private Address shippingAddress;	
	private Address billingAddress;
	
	public CustomerType getCustomerType() {
		return customerType;
	}
	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
