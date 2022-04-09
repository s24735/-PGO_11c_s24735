package src.second.tutorial.exception;

public class BookDoesNotExistsException extends RuntimeException {

    public BookDoesNotExistsException(String message) {
        super(message);
    }
}
