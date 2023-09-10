package utkarsh.OrderFood.exception;

public class RestaurantAlreadyExistsException extends RuntimeException {
    public RestaurantAlreadyExistsException() {
        super("RESTUARANT ALREADY EXISTS");
    }
}
