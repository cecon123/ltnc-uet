public class Main {

    public static void main(String[] args) {
        // 1. Singleton
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log("Kiểm tra Singleton");
        System.out.println("Logger1 hashCode: " + logger1.hashCode());
        System.out.println("Logger2 hashCode: " + logger2.hashCode());

        System.out.println();

        // 2. Factory Method
        ExportApp pdfApp = new PdfExportApp();
        pdfApp.runExport();

        ExportApp excelApp = new ExcelExportApp();
        excelApp.runExport();

        System.out.println();

        // 3. Adapter
        Player player = new PlayerAdapter();
        player.play("music.mp3");

        System.out.println();

        // 4. Prototype
        Config original = new Config("MyApp", "Light");
        Config copy = original.clone();
        copy.setTheme("Dark");

        System.out.println("Cấu hình gốc:");
        original.printConfig();

        System.out.println("Cấu hình bản sao:");
        copy.printConfig();
    }
}
