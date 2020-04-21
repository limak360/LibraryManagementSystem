public class Address {
    private String Country;
    private String City;
    private String state;
    private String zipCode;
    private String streetAddress;

    public Address(String country, String city, String state, String zipCode, String streetAddress) {
        Country = country;
        City = city;
        this.state = state;
        this.zipCode = zipCode;
        this.streetAddress = streetAddress;
    }

    public String getCountry() {
        return Country;
    }

    public String getCity() {
        return City;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }
}
