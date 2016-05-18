package com.ecommerce.framework.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository implements IRepository {
	Map<String, Item> items;
	private static Repository INSTANCE;
	private Repository() {
		items = new HashMap<String,Item>();
	}
	
	public static Repository getInstance(){
		if(INSTANCE==null){
			INSTANCE = new Repository();
		}
		return INSTANCE;
	}

	public Item saveItem(Item item) throws Exception {
		if (items.containsKey(item.getItemID()))
			throw new Exception("Illegal Argument");
		items.put(item.getItemID(), item);
		return item;
	}
	
	public List<Item> vewItemsByCategory(String category){
		List<Item> list = new ArrayList<Item>();
		for(Map.Entry<String, Item> item: items.entrySet()){
			if(item.getValue().getCategory().equals(category)){
				list.add(item.getValue());
			}
			
		}
		return list;
	}
	
	

}
