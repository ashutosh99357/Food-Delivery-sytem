package Managers;

import data.PaymentResponse;

public class NetBankingPaymentManager implements PaymentManager{

	private final String bankName;
	private final String userName;
	private final String passWord;
	private final String pin;
	private final double amount;
	
	public NetBankingPaymentManager(String bankName,String userName,String passWord,String pin,double amount)
	{
		this.amount=amount;
		this.bankName=bankName;
		this.passWord=passWord;
		this.pin=pin;
		this.userName=userName;
	}
	@Override
	public PaymentResponse executePayment() {
		
		// TODO Auto-generated method stub
		return null;
	}
	public String getBankName() {
		return bankName;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public String getPin() {
		return pin;
	}
	public double getAmount() {
		return amount;
	}
	
	

}
