package pl.jackokamil.librarymanagementsystem.notification;

import java.util.Date;

public class EmailNotification extends Notification {
    public EmailNotification(int notificationId, Date createdOn, String content) {
        super(notificationId, createdOn, content);
    }
}
