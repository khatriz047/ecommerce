package com.ecommerce.framework.product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chandra Prakash Panday
 */
public class ProductCatalog extends CatalogComponent {
	private List<CatalogComponent> products = new ArrayList<>();
	private String name;

	public ProductCatalog(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void print() {
		for (CatalogComponent catalog : products) {
			catalog.print();
		}
	}

	@Override
	public void add(CatalogComponent catalogComponent) {
		products.add(catalogComponent);
	}

	@Override
	public void remove(CatalogComponent catalogComponent) {
		products.remove(catalogComponent);
	}
	
	@Override
	public List<CatalogComponent> getChilds() {
		return products;
	}

}