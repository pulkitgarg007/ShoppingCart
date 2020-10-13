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
		for(DiscountSlabs slab: DiscountSlabs.values()) {
			Double compare1 = Double.parseDouble(slab.getSlab().split("-")[0]);
			Double compare2 = null;
			if(!slab.getSlab().split("-")[1].equals("end")) {
				compare2 = Double.parseDouble(slab.getSlab().split("-")[1]);
			}
			if(totalAmount>compare1) {
				double discountRate = slab.getDiscount();
				if(compare2==null) {
					discount = discount + (totalAmount-compare1)*discountRate/100;
				}else if(totalAmount>=compare2) {
					discount = discount + (compare2-compare1)*discountRate/100;
				}else {
					discount = discount + (totalAmount-compare1)*discountRate/100;
				}
			}
		}
		return totalAmount-discount;
	}
	
	private enum DiscountSlabs {
		SLAB1("0-5000",0),
		SLAB2("5000-10000",10),
		SLAB3("10000-end",20);
		
		private String slab;
		private double discount;
		
		DiscountSlabs(String slab, int discount) {
			this.slab = slab;
			this.discount = discount;
		}

		public String getSlab() {
			return slab;
		}

		public double getDiscount() {
			return discount;
		}
	}

}
