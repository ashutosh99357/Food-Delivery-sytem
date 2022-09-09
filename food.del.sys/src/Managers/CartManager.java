package Managers;


import java.util.List;

import Factory.PermissionFactory;
import data.CartItem;
import data.DataAccessObjectConvertor;
import data.DataAccessResult;
import data.DataAccessor;
import data.FoodItem;
import data.User;
import perm.Permission;

public class CartManager {

	public List<CartItem> getUserCart(User user)
	{
		DataAccessResult dataAccessResult = DataAccessor.getCart(user);
		return DataAccessObjectConvertor.convertToCartItems(dataAccessResult);
	}
	public void addItemToCart(User user, FoodItem foodItem)
	{
		Permission permission= PermissionFactory.getAddToCartPermission(user, foodItem); 
		if (!permission.isPermitted())
			throw new RuntimeException("Permission Denied");

			if (!isFoodFromSameRestaurant (user, foodItem))
			 throw new RuntimeException("Your cart contains items from diff restaurant"); DataAccessor.addItemToCart (user, foodItem);
			 DataAccessor.addItemToCart(user,foodItem);
	}
	public void deleteItemToCart(User user, FoodItem foodItem)
	{
		Permission permission= PermissionFactory.getDeleteFromCartPermission(user, foodItem); 
		if (!permission.isPermitted())
			throw new RuntimeException("Permission Denied");
		if(!isFoodItemPresentInCart(user,foodItem))
			throw new RuntimeException("fooditem not present");
		DataAccessor.deleteItemFromCart(user,foodItem);
	}
	public void checkOutUserCart(User user)
	{
		Permission permission= PermissionFactory.getCheckOutCartCartPermission(user); 
		if (!permission.isPermitted())
			throw new RuntimeException("Permission Denied");
		if(isCartEmpty()(user))
			throw new RuntimeException("cart empty");
		DataAccessor.checkOutCart(user);
	}
	private boolean isFoodFromSameRestaurant(User user, FoodItem foodItem)
	{
		List<CartItem> cartItems = getUserCart(user);
		return cartItems.isEmpty() || (cartItems.get(0).getFoodItem().getRestaurantId() == foodItem.getRestaurantId());
	}
	private boolean isFoodItemPresentInCart(User user, FoodItem foodItem)
	{
		List<CartItem> cartItems= getUserCart(user);
		for(CartItem item:cartItems)
		{
			if(item.getFoodItem().getId() == foodItem.getId())
				return true;
		}
		return false;
	}
	private boolean isCartEmpty( User user)
	{
		List<CartItem> cartItems = getUserCart(user);
		return cartItems.isEmpty();
	}
}
