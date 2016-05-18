package com.ecommerce.framework.repository;

import com.ecommerce.framework.product.Product;
import com.ecommerce.framework.userconfig.IUser;

import java.util.List;

public interface IRepository {
	/*public Item saveItem(Item item) throws Exception;
	public List<Item> vewItemsByCategory(String category);
*/

	public void saveUser(IUser user) throws Exception;
	public IUser getUserFromUserName(String username);
	public List<IUser> getListOfUser();

	public void saveProduct(Product product) throws Exception;
	 List<Product> getListOfProduct();
	Product getProduct(String productId);
}
