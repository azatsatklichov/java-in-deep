package net.sahet.designpatterns.behavioral.strategy;

public abstract class CardValidator {

	/**
	 * A credit card number must have between 13 and 16 digits. It must start with:
	 * 
	 * 4 for Visa cards
	 * 
	 * 5 for Master cards
	 * 
	 * 37 for American Express cards
	 * 
	 * 6 for Discover cards
	 * 
	 * @param creditCard
	 * @return
	 */
	public abstract boolean isValid(PaymentCard card);

}
