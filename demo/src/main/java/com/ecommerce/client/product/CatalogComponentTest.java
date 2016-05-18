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

		/* Create primary products for male catalog */
		CatalogComponent electronic1 = new Product("PROD001", "Laptop", 765.00, 10, true);
		CatalogComponent electronic2 = new Product("PROD002", "Mobile", 165.00, 10, true);

		/* Create a composite product catalog and add Male products to it */
		CatalogComponent maleCatalog = new ProductCatalog("Male Products");
		CatalogComponent malesJeanProduct = new Product("PROD003", "M: Jeans 32", 65.00, 10, true);
		CatalogComponent malesTShirtProduct = new Product("PROD004", "M: T Shirt 38", 45.00, 10, true);
		maleCatalog.add(malesJeanProduct);
		maleCatalog.add(malesTShirtProduct);

		/* Create a composite product catalog and add female products to it */
		CatalogComponent femaleCatalog = new ProductCatalog("Female Products");
		CatalogComponent fJeans = new Product("PROD005", "F: Jeans 32", 65.00, 10, true);
		CatalogComponent fTShirts = new MyProduct("PROD006", "F: T Shirt 38", 45.00, 10, true, 0.05);
		femaleCatalog.add(fJeans);
		femaleCatalog.add(fTShirts);

		/* Create a composite product catalog and add kid products to it */
		CatalogComponent kidCatalog = new ProductCatalog("Kids Products");
		CatalogComponent kidShorts = new Product("PROD007", "Return Gift", 23.00, 10, true);
		CatalogComponent kidPlayGears = new Product("PROD008", "Summer Play Gear", 65.00, 10, true);
		CatalogComponent kidPlayBalls = new Product("PROD009", "Balls", 20.00, 10, true);
		kidCatalog.add(kidShorts);
		kidCatalog.add(kidPlayGears);

		/*
		 * Create primary catalog and add primary products and new catalogs to
		 * it
		 */
		CatalogComponent mainCatalog = new ProductCatalog("Primary Catalog");
		mainCatalog.add(electronic1);
		mainCatalog.add(electronic2);
		mainCatalog.add(maleCatalog);
		mainCatalog.add(femaleCatalog);
		mainCatalog.add(kidCatalog);

		/* Print out product/catalog information */
		//mainCatalog.print();
		for (CatalogComponent catalogComponent : mainCatalog.getChilds()) {
			if(catalogComponent.hasChildren()){
				System.out.println("=========="+catalogComponent.getName()+"==========");
				for(CatalogComponent childComponent : catalogComponent.getChilds()) {
					if(!childComponent.hasChildren()){
						System.out.println(childComponent);
					}
				}
			}else {
				System.out.println(catalogComponent);
			}

		}

	}
}