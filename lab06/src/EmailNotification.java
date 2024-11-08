public class EmailNotification implements NotificationSender {
    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("Sending Email to " + recipient + " with message: " + message);
    }
}
