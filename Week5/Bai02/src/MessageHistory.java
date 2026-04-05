import java.util.Stack;

public class MessageHistory {

    private Stack<Message> history;

    public MessageHistory() {
        this.history = new Stack<>();
    }

    public void addMessage(Message message) {
        history.push(message);
        System.out.println("Message saved: " + message.getContent());
    }

    public Message undoMessage() {
        if (history.isEmpty()) {
            System.out.println("No messages to undo.");
            return null;
        }
        Message remmoved = history.pop();
        System.out.println("Undo message: " + remmoved.getContent());
        return remmoved;
    }

    public Message viewLastMessage() {
        if (history.isEmpty()) {
            System.out.println("No messages in the history.");
            return null;
        }
        Message last = history.peek();
        System.out.println("Last message: " + last.getContent());
        return last;
    }
}
