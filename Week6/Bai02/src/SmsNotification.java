public class SmsNotification implements Notification {

    @Override
    public void send(String msg) {
        System.out.println("Send SMS: " + msg);
    }
}
