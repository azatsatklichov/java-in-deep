package net.sahet.designpatterns.behavioral.strategy;

public class VisaCardValidator extends CardValidator {

	@Override
	public boolean isValid(PaymentCard card) {
		return card.getNumber().startsWith("4") && card.getNumber().length() == 16;
	}
}
