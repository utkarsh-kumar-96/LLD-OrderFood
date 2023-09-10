package utkarsh.OrderFood.dao;

import utkarsh.OrderFood.exception.RestaurantAlreadyExistsException;
import utkarsh.OrderFood.exception.RestaurantNotFoundException;
import utkarsh.OrderFood.models.Restaurant;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class RestaurantDao {
    private static RestaurantDao instance;

    private RestaurantDao() {
    }

    private Map<String, Restaurant> map = new ConcurrentHashMap<>();

    public static RestaurantDao getInstance() {
        if (instance == null) {
            synchronized (RestaurantDao.class) {
                if (instance == null) {
                    instance = new RestaurantDao();
                }
            }
        }
        return instance;
    }

    public List<Restaurant> getAll() {
        return map.values().stream().toList();
    }

    public Boolean add(Restaurant restaurant) {
        if (map.containsKey(restaurant.getName())) {
            throw new RestaurantAlreadyExistsException();
        }
        map.put(restaurant.getName(), restaurant);
        return true;
    }

    public String remove(String name) {
        if (null == getByName(name)) throw new RestaurantNotFoundException();
        Restaurant remove = map.remove(name);
        return remove.getName();
    }

    public Optional<Restaurant> getByName(String name) {
        if (!map.containsKey(name)) throw new RestaurantNotFoundException();
        return Optional.of(map.get(name));
    }

}
