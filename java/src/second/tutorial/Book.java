package src.second.tutorial;

import java.time.LocalDate;

public class Book {
    private static Long id = 0L;
    private String name;
    private Genre genre;
    private Lang lang;
    private LocalDate publishDate;
    private static int borrowCount = 0;
    private boolean isAvailable = true;

    public Book(String name, Genre genre, Lang lang, LocalDate publishDate) {
        id++;
        validFields(name, genre, lang);
        this.name = name;
        this.genre = genre;
        this.lang = lang;
        this.publishDate = publishDate;
    }

    public String getName() {
        return name;
    }

    private void validFields(String name, Genre genre, Lang lang) {
        if (name == null || name.isBlank()
                || genre == null
                || lang == null) {
            throw new InvalidValueProvidedException("Niepoprawna wartość. Żadne Pole nie może być puste.");
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", genre=" + genre +
                ", lang=" + lang +
                ", publishDate=" + publishDate +
                ", borrowCount=" + borrowCount +
                ", isAvailable=" + isAvailable +
                '}';
    }

    public void borrowBook(Person person) {
        if (!Main.database.containsValue(this)) {
            throw new BookDoesNotExists("Book does not exists.");
        }
        if (Main.borrowerWithBook.containsValue(person)) {
            throw new TooManyBooksBorrowed();
        }
        if (!this.isAvailable) {
            throw new BookDoesNotExists("Book is not available.");
        }
        this.isAvailable = false;
        Main.borrowerWithBook.put(this, person);
        System.out.println("Person " + person.getName() + " borrowed book: " + this.getName());
    }

    public void placeBack() {
        if (Main.borrowerWithBook.containsKey(this)) {
            this.isAvailable = true;
            Main.borrowerWithBook.remove(this);
            System.out.println("Book " + this.getName() + " returned to library");
        }
        else {
            System.out.println("Book " + this.getName() + " was never borrowed");
        }
    }
}

