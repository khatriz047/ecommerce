package com.ecommerce.framework.product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chandra Prakash Panday
 */
public class ProductCatalog extends CatalogComponent {
    private List<CatalogComponent> products = new ArrayList<>();
    private String name;
    private boolean hasChildren;

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
        hasChildren = true;
    }

    @Override
    public void remove(CatalogComponent catalogComponent) {
        products.remove(catalogComponent);
        if (products.size() == 0) {
            hasChildren = false;
        }
    }

    @Override
    public List<CatalogComponent> getChilds() {
        return products;
    }

    @Override
    public boolean hasChildren() {
        return hasChildren;
    }

}