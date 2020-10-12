package com.shoppingcart.billing;

import java.util.Map;

import com.shoppingcart.product.IProduct;

public interface BillingStrategy {

	public double calculateBillingAmount(Map<IProduct,Integer> products);

}
