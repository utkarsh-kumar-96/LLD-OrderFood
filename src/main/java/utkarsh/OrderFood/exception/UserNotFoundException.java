package utkarsh.OrderFood.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("NOT USER FOUND");
    }
}
