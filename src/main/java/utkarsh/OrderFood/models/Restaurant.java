package utkarsh.OrderFood.models;

import lombok.Builder;
import lombok.Getter;
import utkarsh.OrderFood.exception.OutOfStockException;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
public class Restaurant {
    private String id;
    private String name;
    private List<String> pincodes = new ArrayList<>();
    private FoodItem foodItem;
    private Rating rating = new Rating();

    public void addComment(String comment, Integer rating) {
        this.rating.addRatingAndComment(comment, rating);
    }

    public boolean placeOrder(int qty) throws OutOfStockException {
        if (!isEnoughQty(qty)) throw new OutOfStockException();
        foodItem.setQty(foodItem.getQty() - qty);
        return true;
    }

    public boolean isLocationServicable(String pincode) {
        return pincodes.contains(pincode);
    }

    public boolean isEnoughQty(int qty) {
        return this.foodItem.getQty() >= qty;
    }

    public Double getRating() {
        return this.rating.getAvgRating();
    }

    public Integer updateQty(Integer qty) {
        foodItem.setQty(foodItem.getQty() + qty);
        return foodItem.getQty();
    }
}