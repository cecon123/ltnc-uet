public class Main {

    public static void main(String[] args) {
        Folder root = new Folder("root");
        Folder docs = new Folder("docs");

        FileItem fileA = new FileItem("a.txt", 12);
        FileItem fileB = new FileItem("b.txt", 8);
        FileItem readme = new FileItem("readme.md", 4);

        Shortcut shortcutA = new Shortcut(
            "a-shortcut",
            fileA,
            "/root/docs/a.txt"
        );

        docs.addItem(fileA);
        docs.addItem(fileB);
        docs.addItem(shortcutA);

        root.addItem(docs);
        root.addItem(readme);

        root.print("");
    }
}
