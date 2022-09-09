package apis;

import java.util.Map;

import Factory.PaymentManagerFactory;
import Managers.OrderManager;
import Managers.PaymentManager;
import Managers.UserManager;
import data.Order;
import data.PaymentResponse;
import data.PaymentStatus;
import data.User;

public class PlaceOrderAPI {

	private final UserManager  userManager= new  UserManager();
	private final OrderManager orderManager = new OrderManager();
	public Order placeOrder(String userToken, Map<String,String> paymentInfo, String paymentMode)
	{
		private final UserManager userManager = new UserManager();
		if(userToken ==null ||userToken.length()==0)
			throw new IllegalArgumentException("Prams missing");
		User user = userManager.getUserByToken(userToken);
		if(user==null)
			throw new IllegalArgumentException("userToken Invalid");
        PaymentManager paymentManager = PaymentManagerFactory.getPaymentManager(paymentMode, paymentInfo) ;
        PaymentResponse   paymentResponse =paymentManager.executePayment();
        if(  paymentResponse ==null ||   paymentResponse.getStatus() ==null || paymentResponse.getStatus().equals(PaymentStatus.Failure) )
        	throw new RuntimeException("payment failed");
        return orderManager.placeOrder(user);
	}
	public UserManager getUserManager() {
		return userManager;
	}
}
