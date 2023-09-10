package utkarsh.OrderFood.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class FoodItem {
	private String name;
	private Double price;
	private Integer qty;
}
