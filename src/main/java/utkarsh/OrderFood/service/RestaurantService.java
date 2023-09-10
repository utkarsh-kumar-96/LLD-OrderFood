package utkarsh.OrderFood.service;

import utkarsh.OrderFood.dao.RestaurantDao;
import utkarsh.OrderFood.dao.UserDao;
import utkarsh.OrderFood.exception.RestaurantAlreadyExistsException;
import utkarsh.OrderFood.exception.RestaurantNotFoundException;
import utkarsh.OrderFood.models.FoodItem;
import utkarsh.OrderFood.models.Restaurant;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RestaurantService {
    RestaurantDao restaurantDao = RestaurantDao.getInstance();
    UserDao userDao = UserDao.getInstance();

    public boolean registerRestaurant(String name, List<String> pincodes, FoodItem item) {
        Restaurant restaurant = Restaurant.builder().id(UUID.randomUUID().toString()).name(name).pincodes(pincodes).foodItem(item).build();
        try {
            restaurantDao.add(restaurant);
        } catch (RestaurantAlreadyExistsException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public Integer updateQty(String resName, Integer qty) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurant = restaurantDao.getByName(resName);
        if (restaurant.isEmpty()) return -999;
        return restaurant.get().updateQty(qty);
    }

    public Double rateRestaurant(String name, String comment, Integer rating) throws RestaurantNotFoundException {
        Optional<Restaurant> optionalRestaurant = restaurantDao.getByName(name);
        if (optionalRestaurant.isEmpty()) return -999.0;
        Restaurant restaurant = optionalRestaurant.get();
        restaurant.addComment(comment, rating);
        return restaurant.getRating();
    }

    public boolean placeOrder(String restaurantName, Integer qty) {
        Optional<Restaurant> restaurantOptional = restaurantDao.getByName(restaurantName);
        if(!restaurantOptional.isEmpty())
            return false;
        Restaurant restaurant = restaurantOptional.get();
        restaurant.placeOrder(qty);
        return true;
    }
}