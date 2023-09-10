package utkarsh.OrderFood.models;

import lombok.Builder;

@Builder
public class Order {
	String id;
	FoodItem item;
	User user;
}
