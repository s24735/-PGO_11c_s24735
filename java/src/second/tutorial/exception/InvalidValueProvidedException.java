package src.second.tutorial.exception;

public class InvalidValueProvidedException extends RuntimeException {

    public InvalidValueProvidedException(String msg) {
        super(msg);
    }
}
