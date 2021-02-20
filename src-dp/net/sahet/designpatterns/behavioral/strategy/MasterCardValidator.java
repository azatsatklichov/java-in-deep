package net.sahet.designpatterns.behavioral.strategy;

public class MasterCardValidator extends CardValidator {

	@Override
	public boolean isValid(PaymentCard creditCard) {
		int len = creditCard.getNumber().length();
		return creditCard.getNumber().startsWith("5") && (len >= 13 || len <= 16);
	}
}
