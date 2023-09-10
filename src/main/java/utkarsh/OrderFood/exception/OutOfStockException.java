package utkarsh.OrderFood.exception;

public class OutOfStockException extends RuntimeException {

    public OutOfStockException() {
        super("OOPS :: OUT OF ORDER");
    }

    public OutOfStockException(String message) {
        super(message);
    }
}
