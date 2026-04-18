public class OrderInfo {

    private final String id;
    private final long processMs;

    public OrderInfo(String id, long processMs) {
        this.id = id;
        this.processMs = processMs;
    }

    public String getId() {
        return id;
    }

    public long getProcessMs() {
        return processMs;
    }
}
