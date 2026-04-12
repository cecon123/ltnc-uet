import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSystemItem {
    private List<FileSystemItem> children;

    public Folder(String name) {
        super(name);
        this.children = new ArrayList<>();
    }

    public void addItem(FileSystemItem item) {
        children.add(item);
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Folder: " + name);
        for (FileSystemItem item : children) {
            item.print(indent + "    ");
        }
    }
}