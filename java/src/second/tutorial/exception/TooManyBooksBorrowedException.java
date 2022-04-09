package src.second.tutorial.exception;

public class TooManyBooksBorrowedException extends RuntimeException {

    public TooManyBooksBorrowedException() {
        super("You have currently borrowed one book. Return it to borrow a new one.");
    }
}
