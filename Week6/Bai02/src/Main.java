public class Main {

    public static void main(String[] args) {
        NotificationApp app;
        app = new EmailApp();
        app.notifyUser("Hello, this is an email notification!");

        app = new SmsApp();
        app.notifyUser("Hello, this is an SMS notification!");
    }
}
