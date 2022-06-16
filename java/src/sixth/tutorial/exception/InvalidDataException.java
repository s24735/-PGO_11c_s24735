package src.sixth.tutorial.exception;

public class InvalidDataException extends RuntimeException {

    public InvalidDataException(String s) {
        super(s);
    }
}
