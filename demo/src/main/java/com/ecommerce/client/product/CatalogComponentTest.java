package com.ecommerce.client.product;

import com.ecommerce.framework.product.*;

/**
 * @author Chandra Prakash Panday
 */
public class CatalogComponentTest {
	public static void main(String[] args) {
		try {
			testPrint();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testPrint() throws Exception {

		/* Create primary products for main catalog */
		CatalogComponent mJeanProduct = new Product("PROD001", "M: Jeans 32", 65.00, 10, true);
		CatalogComponent mTShirtProduct = new Product("PROD002", "M: T Shirt 38", 45.00, 10, true);

		/* Create a composite product catalog and add female products to it */
		CatalogComponent newCatalog = new ProductCatalog("Female Products");
		CatalogComponent fJeans = new Product("PROD003", "F: Jeans 32", 65.00, 10, true);
		CatalogComponent fTShirts = new MyProduct("PROD004", "F: T Shirt 38", 45.00, 10, true, 0.05);
		newCatalog.add(fJeans);
		newCatalog.add(fTShirts);

		/* Create a composite product catalog and add kid products to it */
		CatalogComponent kidCatalog = new ProductCatalog("Kids Products");
		CatalogComponent kidShorts = new Product("PROD005", "Return Gift", 23.00, 10, true);
		CatalogComponent kidPlayGears = new Product("PROD006", "Summer Play Gear", 65.00, 10, true);
		kidCatalog.add(kidShorts);
		kidCatalog.add(kidPlayGears);

		/*
		 * Create primary catalog and add primary products and new catalogs to
		 * it
		 */
		CatalogComponent mainCatalog = new ProductCatalog("Primary Catalog");
		mainCatalog.add(mJeanProduct);
		mainCatalog.add(mTShirtProduct);
		mainCatalog.add(newCatalog);
		mainCatalog.add(kidCatalog);

		/* Print out product/catalog information */
		mainCatalog.print();
		/*for (CatalogComponent catalogComponent : mainCatalog.getChilds()) {

			System.out.println(catalogComponent.getPrice());
		}*/

	}
}