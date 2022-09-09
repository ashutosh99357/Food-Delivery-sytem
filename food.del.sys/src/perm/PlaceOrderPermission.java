package perm;

import data.User;

public class PlaceOrderPermission implements Permission{

	private final  User user;
	public PlaceOrderPermission(User user)
	{
		this.user=user;
	}
	@Override
	public boolean isPermitted() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
