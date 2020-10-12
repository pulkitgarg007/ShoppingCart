package com.shoppingcart.billing;

import java.util.Map;

import com.shoppingcart.product.IProduct;

public class DefaultCustomer implements BillingStrategy {

	@Override
	public double calculateBillingAmount(Map<IProduct, Integer> products) {
		double totalAmount =0;
		for(Map.Entry<IProduct,Integer> entry:products.entrySet()) {
			IProduct product = entry.getKey();
			totalAmount =totalAmount+( product.getPrice()*entry.getValue());
		}
		return totalAmount;
	}


}
