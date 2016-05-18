package com.ecommerce.framework.payment;

import java.util.Date;
/*
 * created by Anup
 */

/* Concrete Strategy Class*/
public class DebitCard implements PaymentMethod {

    private String name;
    private String cardNumber;
    private Date expires;

    public String getName() {
        return name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Date getExpires() {
        return expires;
    }

    public DebitCard() {

    }

    public DebitCard(String name, String cardNumber, Date expires) {
        super();
        this.name = name;
        this.cardNumber = cardNumber;
        this.expires = expires;
    }

    @Override
    public void pay(double amount) {
        System.out.println("This amount " + amount + " is paid from " + name + " via debit card");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }
}