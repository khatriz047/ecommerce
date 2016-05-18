package com.ecommerce.framework.calculator;

import com.ecommerce.framework.domain.Book;
import com.ecommerce.framework.domain.Dvd;

/**
 * Created by Sandip on 5/17/16.
 */
public interface IVisitor {
 double visit(Book book);
 double visit(Dvd dvd);
}
