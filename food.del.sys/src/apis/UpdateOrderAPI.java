package apis;

import Managers.OrderManager;
import Managers.UserManager;
import data.OrderStatus;
import data.User;

public class UpdateOrderAPI {

	UserManager userManager= new UserManager();
	OrderManager orderManager= new OrderManager(); 
	public void updateOrderId(int orderId, OrderStatus status, String userToken)
	{
		User user = userManager.getUserByToken(userToken);
		if(user == null || userToken==null)
			throw new IllegalArgumentException("Prams missing");
		Order order = orderManager.getOrder(orderId);
		if(order ==null)
			throw new IllegalArgumentException("order missing");
		if(status.equals(OrderStatus.COOKING))
			orderManager.setOrderToCooking(user, order);
		
	}
}
