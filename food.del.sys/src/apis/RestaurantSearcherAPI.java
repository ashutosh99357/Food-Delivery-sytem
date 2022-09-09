package apis;

import java.util.ArrayList;
import java.util.List;

import Searcher.RestaurantSearcher;
import data.CuisineType;
import data.MealType;
import data.Restaurant;
import data.StarRating;
import filters.CuisineTypeFilter;
import filters.MealTypeFilter;
import filters.RestaurantFilter;
import filters.StarRatingFilter;

public class RestaurantSearcherAPI {

	public List<Restaurant> searchRestaurant(String restaurantName, MealType mealType, List<CuisineType> cuisineTypes,StarRating rating)
	{
	 //validations
		List<RestaurantFilter> filters = new ArrayList<>();
		if(mealType != null)
			filters.add(new MealTypeFilter(mealType));
		if(cuisineTypes != null)
			filters.add(new CuisineTypeFilter(cuisineTypes));
		if(rating != null)
			filters.add(new StarRatingFilter(rating));
		return new RestaurantSearcher().search(restaurantName,filters);
	}
}
