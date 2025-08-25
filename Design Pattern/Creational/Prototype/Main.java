import java.util.List;

import src.Document;
import src.DocumentRegistry;

public class Main {
    public static void main(String[] args) throws Exception {

        DocumentRegistry registry = new DocumentRegistry();

        try {
            Document annualReport = registry.createDocument("report");
            annualReport.setTitle("Annual Report");
            annualReport.setContent("Annual financial report content.");
            annualReport.setAttachments(List.of("\"Financials.pdf\""));
            annualReport.display();

            Document welcomeLetter = registry.createDocument("letter");
            welcomeLetter.setTitle("Welcome Letter");

            welcomeLetter.display();

            Document originalReport = registry.createDocument("report");
            originalReport.display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}