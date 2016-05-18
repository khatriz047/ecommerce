package com.ecommerce.framework.repository;

import java.util.List;

public interface IRepository {
	public Item saveItem(Item item) throws Exception;
	public List<Item> vewItemsByCategory(String category);
}
