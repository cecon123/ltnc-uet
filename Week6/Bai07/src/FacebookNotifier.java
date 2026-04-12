public class FacebookNotifier extends NotifierDecorator {

    public FacebookNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        sendFacebook(msg);
    }

    private void sendFacebook(String msg) {
        System.out.println("Gửi Facebook: " + msg);
    }
}