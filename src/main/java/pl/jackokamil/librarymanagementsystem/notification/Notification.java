package pl.jackokamil.librarymanagementsystem.notification;

import java.util.Date;

public abstract class Notification {
    private int notificationId;
    private Date createdOn;
    private String content;

    public Notification(int notificationId, Date createdOn, String content) {
        this.notificationId = notificationId;
        this.createdOn = createdOn;
        this.content = content;
    }

    public boolean sentNotification() {
        return false;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId=" + notificationId +
                ", createdOn=" + createdOn +
                ", content='" + content + '\'' +
                '}';
    }
}
