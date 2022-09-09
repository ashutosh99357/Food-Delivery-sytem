package perm;

import data.User;

public class CheckOutCartPermission implements Permission {


	private final User user;
	public CheckOutCartPermission(User user)
	{
		this.user=user;
		
	}
	@Override
	public boolean isPermitted() {
		// TODO Auto-generated method stub
		return false;
	}

}
