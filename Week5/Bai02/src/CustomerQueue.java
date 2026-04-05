import java.util.LinkedList;
import java.util.Queue;

public class CustomerQueue {

    private Queue<Customer> queue;

    public CustomerQueue() {
        this.queue = new LinkedList<>();
    }

    public void addCustomer(Customer customer) {
        queue.offer(customer);
        System.out.println("Added customer: " + customer.getName());
    }

    public Customer processCustomer() {
        if (queue.isEmpty()) {
            System.out.println("No customers in the queue.");
            return null;
        }
        Customer customer = queue.poll();
        System.out.println("Processing customer: " + customer.getName());
        return customer;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}
