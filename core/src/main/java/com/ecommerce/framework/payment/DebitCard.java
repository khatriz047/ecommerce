package com.ecommerce.framework.payment;
import java.util.Date;
/*
 * created by Anup
 */

public class DebitCard implements PaymentMethod {

	private final String name;
	private final String cardNumber;
	private final Date expires;

	public String getName() {
		return name;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public Date getExpires() {
		return expires;
	}

	public DebitCard(String name, String cardNumber, Date expires) {
		super();
		this.name = name;
		this.cardNumber = cardNumber;
		this.expires = expires;
	}

	@Override
	public void pay(double amount) {
		System.out.println("This amount is paid via debit card"+amount); 
		}
}