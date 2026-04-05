public class Ticket {

    private int id;
    private String content;
    private String timestamp;
    
    public Ticket(int id, String content, String timestamp) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
    }
    
    public int getId() {
        return id;
    }
    
    public String getContent() {
        return content;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    
    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
