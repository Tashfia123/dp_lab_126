public class EPostalMailAdapter implements NotificationSender {
    private EPostalMailAPI postalMailAPI;

    public EPostalMailAdapter(EPostalMailAPI postalMailAPI) {
        this.postalMailAPI = postalMailAPI;
    }

    @Override
    public void sendNotification(String recipient, String message) {
        // Assume recipient format: "Name|Address"
        String[] details = recipient.split("\\|");
        String name = details[0];
        String address = details[1];

        postalMailAPI.sendPostalMail(name, address, message);
    }
}
