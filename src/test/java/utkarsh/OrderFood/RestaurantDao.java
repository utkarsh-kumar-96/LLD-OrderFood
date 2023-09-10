package utkarsh.OrderFood;

import org.junit.jupiter.api.*;
import utkarsh.OrderFood.models.FoodItem;
import utkarsh.OrderFood.models.Restaurant;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

public class RestaurantDao {
    static utkarsh.OrderFood.dao.RestaurantDao restaurantDao = utkarsh.OrderFood.dao.RestaurantDao.getInstance();

    @BeforeAll
    public static void init() {
        FoodItem kadaiPaneer = FoodItem.builder().name("Kadai Paneer").qty(5).build();
        FoodItem butterChicken = FoodItem.builder().name("Butter Chicken").qty(6).build();
        FoodItem chickenLababdar = FoodItem.builder().name("Chicken Lababdar").qty(3).build();
        FoodItem shahiPaneer = FoodItem.builder().name("Shahi Paneer").qty(9).build();

        Restaurant.RestaurantBuilder mithaas = Restaurant.builder().id(UUID.randomUUID().toString()).name("Mithaas").foodItem(kadaiPaneer).pincodes(Arrays.asList("201305", "201308"));

        Restaurant.RestaurantBuilder bikaneriwala = Restaurant.builder().id(UUID.randomUUID().toString()).name("Bikaneriwala").foodItem(shahiPaneer).pincodes(Arrays.asList("201305", "201308", "201301"));

        Restaurant.RestaurantBuilder bhaiJee = Restaurant.builder().id(UUID.randomUUID().toString()).name("Bhai Jee").foodItem(chickenLababdar).pincodes(Arrays.asList("201305", "201308", "201306"));

        Restaurant.RestaurantBuilder barbequeNation = Restaurant.builder().id(UUID.randomUUID().toString()).name("Barbeque Nation").foodItem(butterChicken).pincodes(Arrays.asList("201306", "201308"));

        restaurantDao.add(mithaas.build());
        restaurantDao.add(bikaneriwala.build());
        restaurantDao.add(bhaiJee.build());
        restaurantDao.add(barbequeNation.build());
    }

    @Test
    @DisplayName("ADD RESTAURANT")
    public void add() {

        FoodItem chickenLollipop = FoodItem.builder().name("Chicken Lollipop").qty(10).build();
        Restaurant haldirams = Restaurant.builder().id(UUID.randomUUID().toString()).name("Haldirams").foodItem(chickenLollipop).pincodes(Arrays.asList("201305", "201308")).build();

        restaurantDao.add(haldirams);
        Optional<Restaurant> restaurant = null;

        Assertions.assertDoesNotThrow(() -> restaurantDao.getByName(haldirams.getName()));
        restaurant = restaurantDao.getByName(haldirams.getName());
        Assertions.assertEquals(haldirams.getName(), restaurant.get().getName());
    }
}
