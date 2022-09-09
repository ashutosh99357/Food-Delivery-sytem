package filters;

import data.FoodItem;
import data.Restaurant;
import data.StarRating;

public class StarRatingFilter implements FoodItemFilter, RestaurantFilter{

	private final StarRating rating;
	public StarRatingFilter(StarRating rating)
	{
		this.rating=rating;
	}
	@Override
	public boolean filter(FoodItem foodItem) {
		// TODO Auto-generated method stub
		return foodItem.getStarRating().getVal() >= rating.getVal();
	}
	@Override
	public boolean filter(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return restaurant.getRating().getVal() >= rating.getVal();
	}

	
}
