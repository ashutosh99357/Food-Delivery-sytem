package apis;

import Managers.CartManager;
import Managers.UserManager;
import Searcher.FoodItemSearcher;
import data.FoodItem;
import data.User;

public class AddToCartAPI {
 
	private final UserManager userManager = new UserManager();
	private final FoodItemSearcher  foodItemSearcher = new  FoodItemSearcher();
	 private final CartManager cartManager = new CartManager();
	public void addToCart(String userToken, int foodItemId)
	{
		if(userToken == null || userToken.length()==0 || foodItemId<0)
		{
			throw new IllegalArgumentException("Wrong id");
		}
		User user = userManager.getUserByToken(userToken);
		if(user == null)
		{
			throw new IllegalArgumentException("Invalid user");
		}
		FoodItem foodItem= foodItemSearcher.searchById(foodItemId);
		if(foodItem == null)
		{
			throw new IllegalArgumentException("fooditem not found");
		}
		cartManager.addItemToCart(user, foodItem);
		
	}
}
