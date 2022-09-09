package Managers;

import java.util.List;

import Factory.PermissionFactory;
import data.CartItem;
import data.DataAccessor;
import data.Order;
import data.OrderStatus;
import data.User;
import perm.Permission;

public class OrderManager {

	public Order placeOrder(User user)
	{
		Permission permission = PermissionFactory.getPlaceOrderPermission(user);
		if(!permission.isPermitted())
			throw new RuntimeException("Permission denied");
		CartManager cartManager = new CartManager();
		List<CartItem> cartItems = cartManager.getUserCart(user);
		int orderId = DataAccessor.createOrder(user, cartItems);
		cartManager.checkOutUserCart(user);
		
		return new Order(cartItems,orderId,user.getId(),OrderStatus.ORDER_PLACED);
		
	}
	public List<Order> getOrders(User user)
	{
		return null;
	}
	public Order getOrder(int orderId)
	{
		return null;
	}
	public void setOrderToCooking(User user, Order order)
	{
		Permission permission = PermissionFactory.getUpdateOrderPermission(user, order, OrderStatus.COOKING);
		if(!permission.isPermitted())
			throw new RuntimeException("Permission denied");
		if(!order.getOrderStatus().equals(OrderStatus.ORDER_PLACED))
			throw new RuntimeException("only order placed status can be updated to cooking");
		
		
	}
	public void setOrderReadyForDelivery(User user, Order order)
	{
		// Validation can be done in this method and other methods below as well

		if(!order.getOrderStatus().equals(OrderStatus.COOKING))
			throw new RuntimeException("only order placed for  cookin will be updated");
		
	}
	public void setOrderOutForDelivery(User user, Order order)
	{

		if(!order.getOrderStatus().equals(OrderStatus.READY_FOR_DELIVERY))
			throw new RuntimeException("only order placed for  readyfor delivery will be updated");
		
	}	
	public void setOrderReadyForDeliverd(User user, Order order)
	{

		if(!order.getOrderStatus().equals(OrderStatus.OUT_FOR_DELIVERY))
			throw new RuntimeException("only order placed for  out for delivery");
	}
	public void setOrderToCanceled(User user, Order order)
	{

		if(!order.getOrderStatus().equals(OrderStatus.ORDER_PLACED))
			throw new RuntimeException("only order placed for  out for delivery");
	}
	
}
