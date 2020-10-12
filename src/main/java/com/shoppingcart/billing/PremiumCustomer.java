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
		for(PremiumCustomerDiscountSlabs slab: PremiumCustomerDiscountSlabs.values()) {
			Double compare1 = Double.parseDouble(slab.getSlab().split("-")[0]);
			Double compare2 = null;
			if(!slab.getSlab().split("-")[1].equals("end")) {
				compare2 = Double.parseDouble(slab.getSlab().split("-")[1]);
			}
			if(totalAmount>compare1) {
				if(compare2==null) {
					discount = discount + (totalAmount-compare1)*slab.getDiscount()/100;
				}else if(totalAmount>=compare2) {
					discount = discount + (compare2-compare1)*slab.getDiscount()/100;
				}else {
					discount = discount + (totalAmount-compare1)*slab.getDiscount()/100;
				}
			}
		}
		return totalAmount-discount;
	}
	
	public enum PremiumCustomerDiscountSlabs {
		SLAB1("0-4000",10),
		SLAB2("4000-8000",15),
		SLAB3("8000-12000",20),
		SLAB4("12000-end",30);
		
		private String slab;
		private double discount;
		
		PremiumCustomerDiscountSlabs(String slab, int discount) {
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
