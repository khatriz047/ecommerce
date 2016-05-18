package com.ecommerce.framework.cart;

/**
 * Created by Sandip on 5/17/16.
 */
public class ShoppingCartItem{
    private int quantity;
    private IProduct product;

    public ShoppingCartItem(IProduct product){
        this.product =product;
        quantity=1;
    }
    public ShoppingCartItem(IProduct product, int quantity){
        this.product =product;
        this.quantity = quantity;
    }

    public void increaseQuantity(){
        quantity++;
    }

    public boolean hasProduct(IProduct product){
      return   (this.product.getId()==product.getId())?true:false;
    }

    public int getQuantiy(){
        return  this.quantity;
    }

    public IProduct getProduct(){
        return this.product;
    }

}
