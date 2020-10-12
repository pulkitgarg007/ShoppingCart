package com.shoppingcart.controller;

import com.shoppingcart.billing.BillingStrategy;
import com.shoppingcart.cart.ICart;
import com.shoppingcart.customer.CustomerFactory;
import com.shoppingcart.customer.CustomerType;

public class BillingController {
	
	public double calculateBillingAmount(ICart cart,CustomerType customer) {
		BillingStrategy strategy = CustomerFactory.getCustomer(customer);
		return cart.checkout(strategy);
	}


}
