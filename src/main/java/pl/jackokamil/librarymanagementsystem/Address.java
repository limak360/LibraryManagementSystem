package pl.jackokamil.librarymanagementsystem;

import javax.validation.constraints.NotNull;

public class Address {
    @NotNull
    private String country;
    @NotNull
    private String city;
    @NotNull
    private String state;
    @NotNull
    private String zipCode;
    @NotNull
    private String streetAddress;

    public static class Builder {
        private String country;
        private String city;
        private String state;
        private String zipCode;
        private String streetAddress;

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public Builder zipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder streetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }

    public Address(Builder builder) {
        this.country = builder.country;
        this.city = builder.city;
        this.state = builder.state;
        this.zipCode = builder.zipCode;
        this.streetAddress = builder.streetAddress;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
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

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                '}';
    }
}
