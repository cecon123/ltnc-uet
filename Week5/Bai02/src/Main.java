public class Main {

    public static void main(String[] args) {
        CustomerQueue customerQueue = new CustomerQueue();

        // Add customers to the queue
        customerQueue.addCustomer(new Customer(1, "A"));
        customerQueue.addCustomer(new Customer(2, "B"));

        System.out.println();

        // Process customer A
        Customer currentCustomer = customerQueue.processCustomer();
        if (currentCustomer != null) {
            System.out.println(
                "Start a chat with " + currentCustomer.getName()
            );

            MessageHistory history = new MessageHistory();
            history.addMessage(new Message(1, "Hello, how can I assist you?"));
            history.addMessage(
                new Message(2, "Please provide your order number.")
            );
            history.addMessage(
                new Message(3, "Thank you, I'm checking the system.")
            );

            // View last message
            history.viewLastMessage();

            // Undo 1 message
            history.undoMessage();
            history.viewLastMessage();

            System.out.println();

            // Process customer B
            Customer nextCustomer = customerQueue.processCustomer();

            if (nextCustomer != null) {
                System.out.println(
                    "Start a chat with " + nextCustomer.getName()
                );
            }

            System.out.println();

            // If we continue processing when no one is left...
            customerQueue.processCustomer();
        }
    }
}
