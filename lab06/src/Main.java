public class Main {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService(new EPostalMailAdapter(new EPostalMailAPI()));



        notificationService.notifyUser("Tasnia Anower|Baord Bazar,Gazipur", "Hii via Postal Mail!");
    }
}
