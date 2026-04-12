public class Main {

    public static void main(String[] args) {
        Report report = new Report("Báo cáo tháng", "Doanh thu tăng 20%");

        ReportFormatter jsonFormatter = new JsonFormatter();
        ReportService jsonService = new ReportService(jsonFormatter);
        System.out.println("JSON Output:");
        System.out.println(jsonService.export(report));

        System.out.println();

        ReportFormatter xmlFormatter = new XmlFormatter();
        ReportService xmlService = new ReportService(xmlFormatter);
        System.out.println("XML Output:");
        System.out.println(xmlService.export(report));
    }
}
