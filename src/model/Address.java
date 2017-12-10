package model;

public class Address {

    private String country;
    private String province;
    private String city;
    private String street;
    private String street_number;
    private String postalCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (country != null ? !country.equals(address.country) : address.country != null) return false;
        if (province != null ? !province.equals(address.province) : address.province != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (street_number != null ? !street_number.equals(address.street_number) : address.street_number != null)
            return false;
        return postalCode != null ? postalCode.equals(address.postalCode) : address.postalCode == null;
    }

    @Override
    public int hashCode() {
        int result = country != null ? country.hashCode() : 0;
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (street_number != null ? street_number.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        return result;
    }

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
