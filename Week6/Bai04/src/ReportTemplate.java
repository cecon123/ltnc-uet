import java.util.ArrayList;
import java.util.List;

public class ReportTemplate implements Cloneable {

    private String title;
    private String footer;
    private List<String> sections;

    public ReportTemplate(String title, String footer, List<String> sections) {
        this.title = title;
        this.footer = footer;
        this.sections = sections;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public List<String> getSections() {
        return sections;
    }

    public void setSections(List<String> sections) {
        this.sections = sections;
    }

    @Override
    public ReportTemplate clone() {
        try {
            ReportTemplate cloned = (ReportTemplate) super.clone();
            cloned.sections = new ArrayList<>(this.sections);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone thất bại", e);
        }
    }

    public void printReport() {
        System.out.println("Title: " + title);
        System.out.println("Footer: " + footer);
        System.out.println("Sections: " + sections);
        System.out.println("-------------------------");
    }
}
