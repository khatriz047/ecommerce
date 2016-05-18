package com.ecommerce.framework.payment;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private final List<Item> items;

	public ShoppingCart() {
		items = new ArrayList<Item>();
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public double calcTotalCost() {
		double total = 0.0;
		for (Item item : items) {
			total += item.getPrice();
		}
		return total;
	}

	public void pay(PaymentMethod method) {
		double totalCost = calcTotalCost();
		 method.pay(totalCost);
	}
}