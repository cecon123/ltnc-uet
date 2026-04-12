public class Shortcut extends FileSystemItem {
    private FileSystemItem target;
    private String targetPath;

    public Shortcut(String name, FileSystemItem target, String targetPath) {
        super(name);
        this.target = target;
        this.targetPath = targetPath;
    }

    public FileSystemItem getTarget() {
        return target;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Shortcut: " + name + " -> " + targetPath);
    }
}