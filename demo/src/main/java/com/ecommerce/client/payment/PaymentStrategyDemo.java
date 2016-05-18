package com.ecommerce.client.payment;

import com.ecommerce.framework.payment.CreditCard;
import com.ecommerce.framework.payment.DebitCard;
import com.ecommerce.framework.payment.PaymentContext;

import java.util.Calendar;
import java.util.Date;

public class PaymentStrategyDemo {

    public static void main(String args[]) {

        PaymentContext paymentContext = new PaymentContext();
        Date expiryDate = getCardExpiryDate();
        paymentContext.setPaymentMethod(new DebitCard("American Express", "1234234534564567", expiryDate));
        /*Later, replace by shoppingCart.calculateCost()*/
        paymentContext.makePayment(200.00);


    }

    private static Date getCardExpiryDate() {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(2015, Calendar.JANUARY, 21);
        return cal.getTime();
    }
}