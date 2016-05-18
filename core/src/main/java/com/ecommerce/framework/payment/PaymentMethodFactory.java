package com.ecommerce.framework.payment;

/**
 * Created by Admin on 5/18/2016.
 */
public class PaymentMethodFactory implements IPaymentMethodFactory {
    @Override
    public PaymentMethod getPaymentMethod(String paymentType) {
        if(paymentType.equalsIgnoreCase("debit")){
            return new DebitCard();
        }else{
            return new CreditCard();
        }
    }
}
