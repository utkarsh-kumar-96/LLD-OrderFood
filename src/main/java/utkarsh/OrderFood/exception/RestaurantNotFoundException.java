package utkarsh.OrderFood.exception;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException() {
        super("RESTAURANT NOT FOUND");
    }
}
