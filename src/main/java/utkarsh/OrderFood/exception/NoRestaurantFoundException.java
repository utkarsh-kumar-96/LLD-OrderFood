package utkarsh.OrderFood.exception;

public class NoRestaurantFoundException extends Exception {
    public NoRestaurantFoundException() {
        super("RESTAURANT NOT FOUND");
    }
}
