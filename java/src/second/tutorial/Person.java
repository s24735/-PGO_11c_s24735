package src.second.tutorial;

import java.time.LocalDate;

public class Person {
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private Address address;

    public void publishBook(Book book) {
        Main.database.put(this, book);
        System.out.println("Author " + this.getName() + " published book: " + book.getName());
    }

    public Person(String name, String surname, LocalDate dateOfBirth, Address address) {
        validFields(name, surname, dateOfBirth, address);
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    private void validFields(String name, String surname, LocalDate dateOfBirth, Address address) {
        if (name == null || name.isBlank()
                || surname == null || surname.isBlank()
                || dateOfBirth == null
                || address == null) {
            throw new InvalidValueProvidedException("Niepoprawna wartość. Żadne Pole nie może być puste.");
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address=" + address +
                '}';
    }
}
