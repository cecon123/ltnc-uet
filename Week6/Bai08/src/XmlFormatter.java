public class XmlFormatter implements ReportFormatter {
    @Override
    public String format(Report report) {
        return "<report>" +
               "<title>" + report.getTitle() + "</title>" +
               "<content>" + report.getContent() + "</content>" +
               "</report>";
    }
}