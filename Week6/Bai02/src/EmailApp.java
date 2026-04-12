public class EmailApp extends NotificationApp {

    @Override
    protected Notification createNotification() {
        return new EmailNotification();
    }
}
