package src;

public class Report extends Document{

    private String reportType;

    public Report() {
        setTitle("Default Report Title");
        setContent("Default Report Content");
        getAttachments().add("Default Attachment 1");
        this.reportType = "Internal";
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getReportType() {
        return this.reportType;
    }

    @Override
    public void display() {
        System.out.println("--- Report ---");
        System.out.println("Title: " + getTitle());
        System.out.println("Type: " + getReportType());
        System.out.println("Content: " + getContent());
        System.out.println("Attachments: " + getAttachments());
        System.out.println();
    }

}
