package apis;

import Searcher.RestaurantSearcher;
import data.Restaurant;

public class GetrestaurantByIdAPI {

	public Restaurant getRestaurantById(int id){
		{
			if(id < 0)
				throw new IllegalArgumentException("Wrong id");
			return new RestaurantSearcher().searchById(id);
		}
	}
}
