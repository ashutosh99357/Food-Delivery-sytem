package perm;

import data.FoodItem;
import data.User;

public class DeleteFromCartPermission implements Permission{

	private final User user;
	private final FoodItem fooditem;
	
	public DeleteFromCartPermission(User user,FoodItem fooditem )
	{
		this.fooditem=foodItem;
		this.user=user;
	}
	@Override
	public boolean isPermitted() {
		// TODO Auto-generated method stub
		return false;
	}

}
