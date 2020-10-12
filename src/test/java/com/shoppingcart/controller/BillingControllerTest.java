package com.shoppingcart.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.shoppingcart.cart.Cart;
import com.shoppingcart.cart.ICart;
import com.shoppingcart.customer.CustomerType;
import com.shoppingcart.product.IProduct;
import com.shoppingcart.product.Product;

@RunWith(JUnit4.class)
public class BillingControllerTest {

	private BillingController billingController;
	private ICart cart;
	@Before
	public void setup() {
		billingController = new BillingController();
		cart = new Cart();
	}

	@Test
	public void test_RegularCustomer_WithPurchaseAmount5000() {
		cart.addProduct(getProduct("1",5000d));
		double billingAmount = billingController.calculateBillingAmount(cart, CustomerType.REGULAR);
		assertEquals(billingAmount, 5000, 0);
	}

	@Test
	public void test_RegularCustomer_WithPurchaseAmount10000() {
		cart.addProduct(getProduct("1",5000d));
		cart.addProduct(getProduct("1",5000d));
		double billingAmount = billingController.calculateBillingAmount(cart, CustomerType.REGULAR);
		assertEquals(billingAmount, 9500, 0);
	}

	private IProduct getProduct(String id, double price) {
		IProduct product = new Product();
		product.setId(id);
		product.setPrice(price);
		return product;
	}

	@Test
	public void test_RegularCustomer_WithPurchaseAmount15000() {
		cart.addProduct(getProduct("1",5000d));
		cart.addProduct(getProduct("1",5000d));
		cart.addProduct(getProduct("2",5000d));
		double billingAmount = billingController.calculateBillingAmount(cart, CustomerType.REGULAR);
		assertEquals(billingAmount, 13500, 0);
	}

	@Test
	public void test_PremiumCustomer_WithPurchaseAmount4000() {
		cart.addProduct(getProduct("1",4000d));
		double billingAmount = billingController.calculateBillingAmount(cart, CustomerType.PREMIUM);
		assertEquals(billingAmount, 3600, 0);
	}

	@Test
	public void test_PremiumCustomer_WithPurchaseAmount8000() {
		cart.addProduct(getProduct("1",4000d));
		cart.addProduct(getProduct("1",4000d));
		double billingAmount = billingController.calculateBillingAmount(cart, CustomerType.PREMIUM);
		assertEquals(billingAmount, 7000, 0);
	}

	@Test
	public void test_PremiumCustomer_WithPurchaseAmount12000() {
		cart.addProduct(getProduct("1",4000d));
		cart.addProduct(getProduct("2",4000d));
		cart.addProduct(getProduct("3",4000d));
		double billingAmount = billingController.calculateBillingAmount(cart, CustomerType.PREMIUM);
		assertEquals(billingAmount, 10200, 0);
	}

	@Test
	public void test_PremiumCustomer_WithPurchaseAmount20000() {
		cart.addProduct(getProduct("1",4000d));
		cart.addProduct(getProduct("4",10000d));
		cart.addProduct(getProduct("5",6000d));
		double billingAmount = billingController.calculateBillingAmount(cart, CustomerType.PREMIUM);
		assertEquals(billingAmount, 15800, 0);
	}

}
