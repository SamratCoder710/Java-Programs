package com.coder.sanam;

import java.util.*;

public class FoodRatings {

    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9, 12, 8, 15, 14, 7});
        foodRatings.changeRating("sushi", 16);          // sushi's rating is now
        System.out.println(foodRatings.highestRated("japanese"));            // return "sushi"
        foodRatings.changeRating("ramen", 16);          // ramen's rating is
        System.out.println(foodRatings.highestRated("japanese"));            // return "ramen"

    }

    class Food{
        String food;
        int rating;
        String cuisine;
        Food(int rating,String food , String cuisine){
            this.cuisine = cuisine;
            this.food = food;
            this.rating = rating;
        }

    }

    Map<String, Food> foodToFood;
    Map<String,TreeSet<Food>> cuisineFoodMap;


    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToFood = new HashMap<>();
        cuisineFoodMap = new HashMap<>();

        int n = foods.length;
        for(int i=0;i<n;i++){
            Food food = new Food(ratings[i], foods[i], cuisines[i]);
            foodToFood.put(foods[i],food);
            TreeSet<Food> set = cuisineFoodMap.getOrDefault(cuisines[i],defaultSet());
            set.add(food);
            cuisineFoodMap.put(cuisines[i],set);
        }

    }

    private static TreeSet<Food> defaultSet() {
        return new TreeSet<>(
                (a, b) -> a.rating != b.rating ? b.rating - a.rating : a.food.compareTo(b.food)
        );
    }

    public void changeRating(String food, int newRating) {
        Food foodObject = foodToFood.get(food);
        TreeSet<Food> set = cuisineFoodMap.get(foodObject.cuisine);
        set.remove(foodObject);
        foodObject.rating = newRating;
        set.add(foodObject);

    }

    public String highestRated(String cuisine) {
        return cuisineFoodMap.get(cuisine).first().food;
    }
}
