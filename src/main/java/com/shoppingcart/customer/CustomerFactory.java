package com.shoppingcart.customer;

import com.shoppingcart.billing.BillingStrategy;
import com.shoppingcart.billing.DefaultCustomer;
import com.shoppingcart.billing.PremiumCustomer;
import com.shoppingcart.billing.RegularCustomer;

public class CustomerFactory {
	
	public static BillingStrategy getCustomer(CustomerType customerType) {
		BillingStrategy billingStrategy;
		switch(customerType) {
		case REGULAR:
			billingStrategy = new RegularCustomer();
			break;
		case PREMIUM:
			billingStrategy = new PremiumCustomer();
			break;
		default:
			billingStrategy = new DefaultCustomer();
			break;
		}
		return billingStrategy;	
	}

}
