package src.second.tutorial;

import src.second.tutorial.exception.InvalidValueProvidedException;

public class Address {
    private String country;
    private String city;
    private String street;
    private int house;
    private int flat;

    public Address(String country, String city, String street, int house, int flat) {
        validFields(country, city, street, house, flat);
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    private void validFields(String country, String city, String street, int house, int flat) {
        if (country == null || country.isBlank()
                || city == null || country.isBlank()
                || street == null || street.isBlank()
                || house <= 0
                || flat <= 0) {
            throw new InvalidValueProvidedException("Niepoprawna wartość. Żadne Pole nie może być puste. Pola liczbowe nie mogą być ujemne");
        }
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", flat=" + flat +
                '}';
    }
}
