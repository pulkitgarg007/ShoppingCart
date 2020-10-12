package com.shoppingcart.discount;

public enum Discount {
	
	SLAB1("0-5000",0),
	SLAB2("5000-10000",10),
	SLAB3("10000-null",20);
	
	private String slab;
	private double discount;
	
	Discount(String slab, int discount) {
		this.slab = slab;
		this.discount = discount;
	}
	
	
}
