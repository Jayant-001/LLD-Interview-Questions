package Problems.Google_Docs.src.persistance;

import java.io.FileWriter;

public class SaveToFile extends Persistance {
    
    final String FILE_PATH = "problems/Google_Docs/document.txt";
    @Override
    public void save(String content) {
        
        try {
            FileWriter writer = new FileWriter(FILE_PATH);
            writer.write(content);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error while saving document to file: " + e.getMessage());
        }
    }
}
