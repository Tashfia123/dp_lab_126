public class NotificationService {

    private NotificationSender notificationSender;
    public NotificationService(NotificationSender notificationSender)
    {
        this.notificationSender = notificationSender;
    }

    public void notifyUser(String recipient, String message) {
        if (notificationSender != null) {
            notificationSender.sendNotification(recipient, message);
        } else {
            System.out.println("Notification method is not set.");
        }
    }
}
