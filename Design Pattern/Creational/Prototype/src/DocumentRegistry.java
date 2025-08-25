package src;

import java.util.HashMap;
import java.util.Map;

public class DocumentRegistry {
    
    private Map<String, Document> documentPrototypes = new HashMap<>();

    public DocumentRegistry() {
        initializeRegistry();
    }

    void initializeRegistry() {
        Letter letter = new Letter();
        Report report = new Report();

        documentPrototypes.put("letter", letter);
        documentPrototypes.put("report", report);
    }

    public Document createDocument(String type) throws CloneNotSupportedException {
        return (Document) documentPrototypes.get(type.toLowerCase()).clone();
    }

}
