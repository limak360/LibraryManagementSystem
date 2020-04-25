package pl.jackokamil.librarymanagementsystem;

import java.util.Date;

public class BarcodeReader {
    private String id;
    private Date registeredAt;
    private boolean active;

    public BarcodeReader(String id, Date registeredAt, boolean active) {
        this.id = id;
        this.registeredAt = registeredAt;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public Date getRegisteredAt() {
        return registeredAt;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "BarcodeReader{" +
                "id='" + id + '\'' +
                ", registeredAt=" + registeredAt +
                ", active=" + active +
                '}';
    }
}
