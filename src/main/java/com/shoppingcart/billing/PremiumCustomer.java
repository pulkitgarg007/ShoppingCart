package com.shoppingcart.billing;

import java.util.Map;

import com.shoppingcart.product.IProduct;

public class PremiumCustomer implements BillingStrategy {

	@Override
	public double calculateBillingAmount(Map<IProduct, Integer> products) {
		double totalAmount =0;
		for(Map.Entry<IProduct,Integer> entry:products.entrySet()) {
			IProduct product = entry.getKey();
			totalAmount =totalAmount+( product.getPrice()*entry.getValue());
		}
		
		double discount =0;
		if(totalAmount>0 && totalAmount>=4000) {
			discount = 10*4000/100;
		}
		if(totalAmount >=4000 && totalAmount >=8000) {
			discount = discount + 4000*15/100;
		}
		if(totalAmount >=8000 && totalAmount >=12000) {
			discount = discount + (4000)*20/100;
		}
		if(totalAmount >=12000) {
			discount = discount + (totalAmount-12000)*30/100;
		}
		
		return totalAmount-discount;
		
	}

}
