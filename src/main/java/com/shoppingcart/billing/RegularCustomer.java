package com.shoppingcart.billing;

import java.util.Map;

import com.shoppingcart.product.IProduct;

public class RegularCustomer implements BillingStrategy {

	@Override
	public double calculateBillingAmount(Map<IProduct, Integer> products) {
		
		double totalAmount =0;
		for(Map.Entry<IProduct,Integer> entry:products.entrySet()) {
			IProduct product = entry.getKey();
			totalAmount =totalAmount+ (product.getPrice()*entry.getValue());
		}
		double discount =0;
		if(totalAmount>0 && totalAmount>=5000) {
			discount = 0;
		}
		if(totalAmount >=5000 && totalAmount >=10000) {
			discount = 5000*10/100;
		}
		if(totalAmount>10000) {
			discount = discount + (totalAmount-10000)*20/100;
		}
		
		return totalAmount-discount;
		
	}

}
