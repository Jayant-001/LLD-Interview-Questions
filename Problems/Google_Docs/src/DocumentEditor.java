package Problems.Google_Docs.src;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class DocumentEditor {
    // Document elements like text, images
    List<String> elements;
    // Rendered document
    String renderedDocument;

    public DocumentEditor() {
        this.elements = new ArrayList<>();
    }

    public void addImage(String imagePath) {
        elements.add("Image: " + imagePath);
    }

    public void addText(String text) {
        elements.add("Text: " + text);
    }

    public String renderDocument() {
        if(renderedDocument == null) {
            String s = "-----------------------------\n";
            s += String.join("\n", elements);
            s += "\n-----------------------------";
            renderedDocument = s;
        }
        return renderedDocument;
    }

    public void printDocument() {
        try {
            String filePath = "problems/Google_Docs/document.txt";
            File file = new File(filePath);
            file.createNewFile();

            FileWriter writer = new FileWriter(filePath);
            writer.write(renderDocument());
            writer.close();
            System.out.println("Document printed to document.txt");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
}
