public abstract class NotificationApp {

    public void notifyUser(String msg) {
        Notification notification = createNotification();
        notification.send(msg);
    }

    protected abstract Notification createNotification();
}
