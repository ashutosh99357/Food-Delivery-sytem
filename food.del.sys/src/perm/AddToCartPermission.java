package perm;

import Managers.DeliveryManager;
import Searcher.RestaurantSearcher;
import data.FoodItem;
import data.Restaurant;
import data.User;

public class AddToCartPermission implements Permission {

	private final User user;
	private final FoodItem foodItem;
	private  final DeliveryManager deliveryManager;
	
	public AddToCartPermission(User user, FoodItem foodItem)
	{
		this.user=user;
	   this.deliveryManager=new DeliveryManager();
	   this.foodItem=foodItem;
	}
	@Override
	public boolean isPermitted() {
		// TODO Auto-generated method stub
		if(!foodItem.isAvailable())
			return false;
		Restaurant restaurant = new RestaurantSearcher().searchById(foodItem.getRestaurantId()); 
		return deliveryManager.isDeliveryPossible(restaurant.getAddress(),user.getAddress());
	}
	
}
