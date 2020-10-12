package com.shoppingcart.application;

import com.shoppingcart.billing.BillingStrategy;
import com.shoppingcart.cart.ICart;
import com.shoppingcart.customer.CustomerFactory;
import com.shoppingcart.customer.CustomerType;

public class BillingController {
	
	private ICart cart;
	
	public BillingController(ICart cart) {
		this.cart = cart;
	}

	public double calculateBillingAmount(CustomerType customer) {
		BillingStrategy strategy = CustomerFactory.getCustomer(customer);
		return cart.checkout(strategy);
	}
}
