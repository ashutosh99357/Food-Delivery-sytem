package Managers;

import data.PaymentResponse;

public class CardBasedPaymentManager implements PaymentManager{

	private final String bankName;
	private final String cardNumber;
	private final String pin;
	private final double amount;
	
	public  CardBasedPaymentManager(String bankName,String cardNumber,String pin,double amount)
	{
		this.amount=amount;
		this.bankName=bankName;
		this.pin=pin;
		this.cardNumber=cardNumber;
	}
	@Override
	public PaymentResponse executePayment() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getBankName() {
		return bankName;
	}
	public String getPin() {
		return pin;
	}
	public double getAmount() {
		return amount;
	}
	public String getCardNumber() {
		return cardNumber;
	}

}
