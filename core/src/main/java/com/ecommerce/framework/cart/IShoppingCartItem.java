package com.ecommerce.framework.cart;

import com.ecommerce.framework.calculator.IVisitor;

/**
 * Created by Sandip on 5/17/16.
 */
public interface IShoppingCartItem {

    double accept(IVisitor visitor);
}
