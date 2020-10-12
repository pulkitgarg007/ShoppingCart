package com.shoppingcart.cart;

import java.util.HashMap;
import java.util.Map;

import com.shoppingcart.billing.BillingStrategy;
import com.shoppingcart.product.IProduct;

public abstract class ICart {
	
	public Map<IProduct,Integer> products;
	
	public ICart() {
		products = new HashMap<>();
	}
	
	public void addProduct(IProduct product) {
		if(products.containsKey(product)) {
			products.put(product, products.get(product)+1);	
		}else {
			products.put(product, 1);
		}
	}
	
	public Map<IProduct, Integer> getProducts() {
		return products;
	}
	
	
	public abstract double checkout(BillingStrategy strategy);
}
