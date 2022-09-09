package filters;

import java.util.List;

import data.CuisineType;
import data.FoodItem;
import data.Restaurant;

public class CuisineTypeFilter implements FoodItemFilter, RestaurantFilter {

	private final List<CuisineType> cuisineTypes;
	public CuisineTypeFilter(List<CuisineType> cuisineTypes)
	{
		this.cuisineTypes=cuisineTypes;
	}
	@Override
	public boolean filter(FoodItem foodItem) {
		// TODO Auto-generated method stub
		return cuisineTypes.contains(foodItem.getCuisineType());
	}
	@Override
	public boolean filter(Restaurant restaurant) {
		// TODO Auto-generated method stub
		List<CuisineType> cuisines = restaurant.getCuisineTypes();
		for(CuisineType cuisineType:cuisineTypes)
		{
			if(cuisines.contains(cuisineType))
				return true;
		}
		return false;
	}

 
}
