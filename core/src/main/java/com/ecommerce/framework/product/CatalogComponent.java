package com.ecommerce.framework.product;

import java.util.List;

/**
 * @author Chandra Prakash Panday
 */
public abstract class CatalogComponent {

	public void add(CatalogComponent catalogComponent) {
		throw new UnsupportedOperationException("Cannot add item to catalog.");
	}

	public void remove(CatalogComponent catalogComponent) {
		throw new UnsupportedOperationException("Cannot remove item from catalog.");
	}

	public List<CatalogComponent> getChilds() {
		throw new UnsupportedOperationException("Cannot get childs from catalog.");
	}

	public String getProductId() {
		throw new UnsupportedOperationException("Cannot get product id from catalog.");
	}

	public int getQuantity() {
		throw new UnsupportedOperationException("Cannot get quantity from catalog.");
	}

	public boolean isActiveFlag() {
		throw new UnsupportedOperationException("Cannot get active flag from catalog.");
	}

	public String getName() {
		throw new UnsupportedOperationException("Cannot return name.");
	}

	public double getPrice() {
		throw new UnsupportedOperationException("Cannot return price.");
	}

	public void print() {
		throw new UnsupportedOperationException("Cannot print.");
	}

	public boolean hasChildren() {
		throw new UnsupportedOperationException("Cannot return price.");
	}



}