public class EmailNotification implements Notification {

    @Override
    public void send(String msg) {
        System.out.println("Send Email: " + msg);
    }
}
