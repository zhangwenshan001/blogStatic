class Food {
    String food;
    String cuisine;
    Integer rating;
    
    public Food(String food, String cuisine, Integer rating) {
        this.food = food;
        this.cuisine = cuisine;
        this.rating = rating;
    }
    
}

class FoodRatings {
    Map<String, PriorityQueue<Food>> cuisinesFood;
    Map<String, Food> menu;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisinesFood = new HashMap<String, PriorityQueue<Food>>();
        menu = new HashMap<String, Food>();
        
        for (int i=0;i<foods.length;i++) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            if (!cuisinesFood.containsKey(cuisines[i])) {
                PriorityQueue<Food> pq = new PriorityQueue<Food>((a,b)->
                    b.rating - a.rating == 0 ? a.food.compareTo(b.food) : b.rating-a.rating);
                cuisinesFood.put(cuisines[i], pq);
            } 
            PriorityQueue<Food> pq = cuisinesFood.get(cuisines[i]);
            pq.add(food);
            menu.put(foods[i], food);
        }
        
    }
    
    public void changeRating(String food, int newRating) {
        Food cur = menu.get(food);
        PriorityQueue<Food> pq = cuisinesFood.get(cur.cuisine);
        pq.remove(cur);
        cur.rating = newRating;
        
        pq.add(cur);
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Food> pq = cuisinesFood.get(cuisine);
        return cuisinesFood.get(cuisine).peek().food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */