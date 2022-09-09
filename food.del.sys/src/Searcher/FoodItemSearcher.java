package Searcher;

import java.util.ArrayList;
import java.util.List;

import data.FoodItem;
import filters.FoodItemFilter;

public class FoodItemSearcher {

	public List<FoodItem> search(String foodItemName, List<FoodItemFilter> filters)
	{
		if(foodItemName == null || foodItemName.length()==0 || filters ==null )
		{
			throw new IllegalArgumentException("Missing params");
		}
		DataAccessResult dataAccessResult = DataAccessor.getFoodItemsWithName(foodItemName);
		List<FoodItem> foodItems = DataAccessObjectConvertor.convertToFoodItems(dataAccessResult);
		for(FoodItemFilter filter:filters)
		{
			List<FoodItem> filteredFoodItems = new ArrayList<>();
			for(FoodItem foodItem:foodItems)
			{
				if(filter.filter(foodItem))
					filteredFoodItems.add(foodItem);
			}
			foodItems= filteredFoodItems;
		}
		return foodItems;
	}
	public FoodItem searchById(int id)
	{
		
	}
}
