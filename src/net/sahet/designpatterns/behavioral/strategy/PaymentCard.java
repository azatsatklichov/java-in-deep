package net.sahet.designpatterns.behavioral.strategy;

public class PaymentCard {

	private String holderName;
	private String number;
	private String issueDate;
	private String cvv;

	private CardValidator cardValidator;

	public PaymentCard(CardValidator cardValidator) {
		this.cardValidator = cardValidator;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public CardValidator getCardValidator() {
		return cardValidator;
	}

	public void setCardValidator(CardValidator cardValidator) {
		this.cardValidator = cardValidator;
	}

	
}
