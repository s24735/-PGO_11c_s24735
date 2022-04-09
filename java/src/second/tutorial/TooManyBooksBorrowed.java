package src.second.tutorial;

public class TooManyBooksBorrowed extends RuntimeException {

    public TooManyBooksBorrowed() {
        super("You have currently borrowed one book. Return it to borrow a new one.");
    }
}
