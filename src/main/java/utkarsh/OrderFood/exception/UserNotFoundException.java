package utkarsh.OrderFood.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
        super("NOT USER FOUND");
    }
}
