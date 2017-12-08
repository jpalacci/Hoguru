package model;

public class Address {

    private String country;
    private String province;
    private String city;
    private String street;
    private String street_number;
    private String postalCode;

    public Address(String country, String province, String city, String street, String street_number, String postalCode) {
        this.country = country;
        this.province = province;
        this.city = city;
        this.street = street;
        this.street_number = street_number;
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getStreet_number() {
        return street_number;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
