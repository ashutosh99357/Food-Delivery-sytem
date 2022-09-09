package Factory;

import java.security.Permission;

import data.FoodItem;
import data.User;
import perm.AddToCartPermission;
import perm.CheckOutCartPermission;
import perm.DeleteFromCartPermission;
import perm.PlaceOrderPermission;

public class PermissionFactory {

	private PermissionFactory() {}
	
	public static Permission getAddToCartPermission(User user, FoodItem foodItem)
	{
		return  new AddToCartPermission(user,foodItem);
	}
	public static Permission getDeleteFromCartPermission(User user, FoodItem foodItem)
	{
		return  new DeleteFromCartPermission(user,foodItem);
	}
	public static Permission getCheckOutCartPermission(User user)
	{
		return  new CheckOutCartPermission(user);
	}
	public static Permission getPlaceOrderPermission(User user)
	{
		return  new PlaceOrderPermission(user);
	}
	public static Permission getUpdateOrderPermission(User user, Order order,OrderStatus orderStatus)
	{
		return new UpdateOrderPermission(user,order,orderStatus);
	}
	// Similarly we can write others methods form various permission in perm like updateorder, checkout, placeorder
	
}
