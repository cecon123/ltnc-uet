public class JsonFormatter implements ReportFormatter {
    @Override
    public String format(Report report) {
        return "{ \"title\": \"" + report.getTitle() +
               "\", \"content\": \"" + report.getContent() + "\" }";
    }
}