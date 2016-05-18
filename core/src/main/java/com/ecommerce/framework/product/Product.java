package com.ecommerce.framework.product;

/**
 * @author Chandra Prakash Panday
 */
public class Product extends CatalogComponent {
	private String productId;
	private String name;
	private double price;
	private int quantity;
	private boolean activeFlag;

	public Product(String productId, String name, double price, int quantity, boolean activeFlag) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.activeFlag = activeFlag;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public double getPrice() {
		return this.price;
	}

	@Override
	public String getProductId() {
		return productId;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}

	@Override
	public boolean isActiveFlag() {
		return activeFlag;
	}

	@Override
	public boolean hasChildren() {
		return false;
	}

	@Override
	public void print() {
		System.out.println("Product [productId=" + productId + ", name=" + name + ", price=" + price + ", quantity="
				+ quantity + ", activeFlag=" + activeFlag + "]");
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", activeFlag=" + activeFlag + "]";
	}

}