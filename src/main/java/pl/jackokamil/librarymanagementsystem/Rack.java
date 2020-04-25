package pl.jackokamil.librarymanagementsystem;

import javax.validation.constraints.NotNull;

public class Rack {
    @NotNull
    private int number;
    @NotNull
    private String locationIdentifier;

    public Rack(int number, String locationIdentifier) {
        this.number = number;
        this.locationIdentifier = locationIdentifier;
    }

    public int getNumber() {
        return number;
    }

    public String getLocationIdentifier() {
        return locationIdentifier;
    }

    @Override
    public String toString() {
        return "Rack{" +
                "number=" + number +
                ", locationIdentifier='" + locationIdentifier + '\'' +
                '}';
    }
}
