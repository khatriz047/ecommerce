package com.ecommerce.framework.payment;
import java.util.Calendar;
import java.util.Date;

public class PaymentStrategyDemo {
	
	public static void main(String args[]){

	  ShoppingCart instance = new ShoppingCart();

	  Item a = new Item("IT001","T-Shirt", 750.43);
	  instance.addItem(a);

	  Item b = new Item("IT002","hat", 102.99);
	  instance.addItem(b);

	  Date expiryDate = getCardExpireyDate();
	  PaymentMethod debitCard = new DebitCard("CaptainDebug", "1234234534564567", expiryDate);

	   instance.pay(debitCard);
	 

	}

	private static Date getCardExpireyDate() {
	  Calendar cal = Calendar.getInstance();
	  cal.clear();
		cal.set(2015, Calendar.JANUARY, 21);
		return cal.getTime();
	}
}