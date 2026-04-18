public class SMSNotifier extends NotifierDecorator {

    public SMSNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        sendSMS(msg);
    }

    private void sendSMS(String msg) {
        System.out.println("Gửi SMS: " + msg);
    }
}