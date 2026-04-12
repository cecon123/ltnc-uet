public class Main {

    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        notifier = new FacebookNotifier(notifier);
        notifier = new SMSNotifier(notifier);

        notifier.send("Hệ thống sẽ bảo trì lúc 22:00");
    }
}
