package src.second.tutorial;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Person, Book> database = new HashMap<>();
    static Map<Book, Person> borrowerWithBook = new HashMap<>();

    public static void main(String[] args) {
        Address address1 = new Address("Poland", "Warsaw", "street", 1, 2);
        Address address2 = new Address("Poland", "Cracow", "street 2", 44, 32);

        Person author = new Person("Krzysztof", "Kowalski", LocalDate.now(), address1);
        Person person2 = new Person("Adam", "Nowak", LocalDate.now(), address2);

        Book hobbit = new Book("Hobbit", Genre.Adventure, Lang.English, LocalDate.now());
        Book book2 = new Book("Book 2", Genre.Classic, Lang.Japanese, LocalDate.now());

        author.publishBook(hobbit);
        hobbit.borrowBook(person2);
        hobbit.placeBack();
    }
}
