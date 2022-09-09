package apis;

import Searcher.FoodItemSearcher;
import data.FoodItem;

public class GetFoodItemByIdAPI {

	public FoodItem getFoodItemById(int id)
	{
		if(id < 0)
			throw new IllegalArgumentException("Wrong id");
		return new FoodItemSearcher().searchById(id);
	}
}
