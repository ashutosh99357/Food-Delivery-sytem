package Searcher;

import java.util.List;

import data.Restaurant;
import filters.RestaurantFilter;

public class RestaurantSearcher {

	public List<Restaurant> search(String restaurantName, List<RestaurantFilter> filters)
	{
		if(restaurantName == null || restaurantName.length()==0 || filters ==null )
		{
			throw new IllegalArgumentException("Missing params");
		}
		// Bit same as fooditemSearcher implement it on your own
	}
	public Restaurant searchById(int id)
	{
		
	}
}
