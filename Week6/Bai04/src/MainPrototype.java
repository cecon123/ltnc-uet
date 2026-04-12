import java.util.ArrayList;
import java.util.List;

public class MainPrototype {

    public static void main(String[] args) {
        List<String> baseSections = new ArrayList<>();
        baseSections.add("Giới thiệu");
        baseSections.add("Nội dung chính");
        baseSections.add("Kết luận");

        ReportTemplate original = new ReportTemplate(
            "Báo cáo gốc",
            "© 2025 Company",
            baseSections
        );

        ReportTemplate report1 = original.clone();
        report1.setTitle("Báo cáo phòng Kinh doanh");

        ReportTemplate report2 = original.clone();
        report2.setTitle("Báo cáo phòng Kỹ thuật");

        System.out.println("Template gốc:");
        original.printReport();

        System.out.println("Bản sao 1:");
        report1.printReport();

        System.out.println("Bản sao 2:");
        report2.printReport();
    }
}
