package src.second.tutorial;

public class BookDoesNotExists extends RuntimeException {

    public BookDoesNotExists(String message) {
        super(message);
    }
}
