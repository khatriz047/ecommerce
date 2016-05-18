package com.ecommerce.client.product;

import com.ecommerce.framework.product.Product;

/**
 * @author Chandra Prakash Panday
 */
public class MyProduct extends Product {
	private double taxRate;

	public MyProduct(String productId, String name, double price, int quantity, boolean activeFlag, double taxRate) {
		super(productId, name, price, quantity, activeFlag);
		this.taxRate = taxRate;
	}

	@Override
	public String toString() {
		return super.toString() + "MyProduct [taxRate=" + taxRate + "]";
	}

	
	@Override
	public void print(){
		System.out.println(this.toString());
	}
}
