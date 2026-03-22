import java.util.ArrayList;
import java.util.List;

public class LibrarySection<T extends MediaItem> {
    private String sectionName;
    private List<T> items;

    public LibrarySection(String sectionName) {
        this.sectionName = sectionName;
        this.items = new ArrayList<>();
    }

    public String getSectionName() {
        return sectionName;
    }

    public void addItem(T item) {
        items.add(item);
        System.out.println("Da them: " + item);
    }

    public boolean removeItem(String id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                System.out.println("Da xoa: " + items.get(i));
                items.remove(i);
                return true;
            }
        }
        System.out.println("Khong tim thay tai lieu voi ma: " + id);
        return false;
    }

    public void displayItems() {
        System.out.println("=== " + sectionName + " ===");
        if (items.isEmpty()) {
            System.out.println("  (Khong co tai lieu)");
        } else {
            for (T item : items) {
                System.out.println("  - " + item);
            }
        }
    }

    public int getItemCount() {
        return items.size();
    }
}
