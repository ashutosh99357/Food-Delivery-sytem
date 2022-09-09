package apis;

import java.util.List;

import data.CuisineType;
import data.FoodItem;
import data.MealType;
import data.StarRating;

public class FoodItemSearcherAPI {
	
public List<FoodItem> searchFoodItems(String foodItemName, MealType mealType, List<CuisineType> cuisines, StarRating rating)
{
  	return null;
}
}

//Searcher : Generic : Based on OCP principle
// Get only those food items whose (name matches foodItemName) and (mT is mealType) and (cT is cuisineType) and (sT >= rating)
//Filter F1 F2 F3
// --foodItem --> F --T/F--->
//List of foodItems
// Based of the list apply filters