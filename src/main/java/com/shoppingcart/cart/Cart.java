package com.shoppingcart.cart;

import com.shoppingcart.billing.BillingStrategy;

public class Cart extends ICart{
	
	public Cart() {
		super();
	}

	@Override
	public double checkout(BillingStrategy strategy) {
		return strategy.calculateBillingAmount(products);
	}
	
}
