package perm;

import data.Order;
import data.OrderStatus;
import data.User;

public class UpdateOrderPermission implements Permission{

	private final User user;
	private final Order order;
	private final OrderStatus orderStatus;
	public UpdateOrderPermission(User user, Order order, OrderStatus orderStatus)
	{
		this.order=order;
		this.user=user;
		this.orderStatus=orderStatus;
		
	}
	@Override
	public boolean isPermitted() {
		// TODO Auto-generated method stub
		return false;
	}
	public User getUser() {
		return user;
	}
	public Order getOrder() {
		return order;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	
	

}
