public class SMSNotification implements NotificationSender {
    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("Sending SMS to " + recipient + " with message: " + message);
    }
}
